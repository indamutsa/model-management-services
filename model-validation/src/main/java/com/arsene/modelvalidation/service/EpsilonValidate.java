package com.arsene.modelvalidation.service;


import com.arsene.modelvalidation.utililties.ServiceUtil;
import com.google.gson.JsonObject;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.evl.EvlModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;


@Service
public class EpsilonValidate {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private FilePersistance filePersistance;

    public String runEngine(MultipartFile model, MultipartFile metaModel, MultipartFile script) throws Exception {

        Path[] paths = filePersistance.saveFile(model, metaModel, script);

        Path modelPath = paths[0];
        Path metaModelPath = paths[1];
        Path scriptPath = paths[2];

        // Get the module after parsing the script
        EvlModule module = serviceUtil.isParsed(scriptPath);

        // Get the model property
        StringProperties modelProperties = serviceUtil.createEmfModel("TreeModel", modelPath, metaModelPath, "true", "false");


        // To help me write in stream the output of the program
        OutputStream outputStream = new ByteArrayOutputStream();
        EmfModel emfModel = new EmfModel();


        emfModel.load(modelProperties, (IRelativePathResolver) null);
        module.getContext().setOutputStream(new PrintStream(outputStream));
        module.getContext().getModelRepository().addModel(emfModel);

        // Run the engine
        module.execute();

        String out = outputStream.toString();

        // Delete the resource after performing transformation
        serviceUtil.deleteFiles(modelPath,
                metaModelPath,
                scriptPath);

        return out;

    }
}
