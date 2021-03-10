package com.arsene.modeltransformation.service;


import com.arsene.modeltransformation.utililties.ServiceUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.etl.launch.EtlRunConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


@Service
public class EpsilonTransform {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private FilePersistance filePersistance;

    public Resource runEngine(MultipartFile sourceModel,
                              MultipartFile sourceMetaModel,
                              MultipartFile targetMetaModel,
                              MultipartFile etlScript) throws Exception {

        Path[] paths = filePersistance.saveFile(sourceModel, sourceMetaModel, targetMetaModel, etlScript);
        serviceUtil.deletePreviousTargetModels();

        Path sourceModelPath = paths[0];
        Path sourceMetaModelPath = paths[1];
        Path targetMetaModelPath = paths[2];
        Path etlScriptPath = paths[3];


        Path targetModelPath = serviceUtil.handleFileName("hdsj.xmi");

        StringProperties sourceProperties = serviceUtil.createEmfModel("Source", sourceModelPath, sourceMetaModelPath, "true", "false");
        StringProperties targetProperties = serviceUtil.createEmfModel("Target", targetModelPath, targetMetaModelPath, "false", "true");


        // Configuring the transformer launcher
        EtlRunConfiguration transformer = EtlRunConfiguration.Builder()
                .withScript(etlScriptPath)
                .withModel(new EmfModel(), sourceProperties)
                .withModel(new EmfModel(), targetProperties)
                .withParameter("parameterPassedFromJava", "Hello from pre")
                .withProfiling()
                .build();

        // Transforming source model into target model
        transformer.run();

        // Making the target model available after running
        transformer.dispose();

        System.out.println(" ----- |||| ------- Finished transformation ----- |||| -------");

        Resource targetModel = filePersistance.loadFile(targetModelPath);

        // Delete the resource after performing transformation
        serviceUtil.deleteFiles(sourceModelPath,
                sourceMetaModelPath,
                targetMetaModelPath,
                etlScriptPath);

        serviceUtil.writeToFile(targetModelPath.toString());

        // We return the transformed model as a resource
        return targetModel;
    }
}
