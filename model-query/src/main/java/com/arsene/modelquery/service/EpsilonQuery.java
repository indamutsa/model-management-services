package com.arsene.modelquery.service;



import com.arsene.modelquery.utililties.ServiceUtil;
import com.google.gson.JsonObject;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;


@Service
public class EpsilonQuery {

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
        EolModule module = serviceUtil.isParsed(scriptPath);

        StringProperties modelProperties = serviceUtil.createEmfModel("TreeModel", modelPath, metaModelPath, "true", "false");

        OutputStream outputStream = new ByteArrayOutputStream();
        EmfModel emfModel = new EmfModel();

        emfModel.load(modelProperties, (IRelativePathResolver) null);
        module.getContext().setOutputStream(new PrintStream(outputStream));
        module.getContext().getModelRepository().addModel(emfModel);

        module.execute();

        String out = outputStream.toString();

        return out;
    }
}
