package com.arsene.modelcomparison.service;


import com.arsene.modelcomparison.utililties.ServiceUtil;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;


@Service
public class EpsilonCompare {

    @Autowired
    private ServiceUtil serviceUtil;

    public boolean runEngine(ArrayList<Path> filePaths) throws Exception {

        Path[] paths = serviceUtil.getModelPaths(filePaths);

        File modelFile1 = new File(paths[0].toUri());
        File modelFile2 = new File(paths[1].toUri());
        File scriptFile = new File(paths[2].toUri());
        Path eclScript = paths[2];



        // Retrieve the the module after parsing the script file
        EclModule module = serviceUtil.isParsed(eclScript);

        // Load the model file and set properties
        PlainXmlModel catalogue1 = new PlainXmlModel();
        catalogue1.setName(modelFile1.getName());
        catalogue1.setFile(modelFile1);
        catalogue1.load();

        // Load the model file and set properties
        PlainXmlModel catalogue2 = new PlainXmlModel();
        catalogue2.setName(modelFile2.getName());
        catalogue2.setFile(modelFile2);
        catalogue2.load();

        // Retrieving the context of both models
        module.getContext().getModelRepository().addModels(catalogue1, catalogue2);

        // Executing the engine that determine if they are comparable
        module.execute();

        // Find out if the models were comparable or not
        boolean status = module.getContext().getMatchTrace().getReduced() != null;

        // Delete the temp file after comparing the model
         serviceUtil.deleteFiles(modelFile1, modelFile2, scriptFile);

        return status;

    }
}
