package com.arsene.merging.service;

import com.arsene.merging.utilities.ServiceUtil;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eml.IEmlModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class EpsilonMerging {

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private FilePersistance filePersistance;

    public String runEngine(MultipartFile model1, MultipartFile model2, MultipartFile eclScript, MultipartFile emlScript) throws Exception {

        Path[] paths = filePersistance.saveFile(model1, model2, eclScript, emlScript);

        Path model1Path = paths[0];
        Path model2Path = paths[1];
        Path eclPath = paths[2];
        Path emlPath = paths[3];
        System.out.println(model1.getOriginalFilename() + " " +  model2.getOriginalFilename() + " " + eclPath + " " + emlPath);

        // Retrieve the the module after parsing the script file
        IEmlModule module = serviceUtil.isParsed(emlPath);
        IEclModule moduleEcl = serviceUtil.isParsedComp(eclPath);

        PlainXmlModel catalogue1 = new PlainXmlModel();
        catalogue1.setName("Catalogue1");
        catalogue1.getAliases().add("In");
        catalogue1.setFile(model1Path.toFile());
        catalogue1.load();

        PlainXmlModel catalogue2 = new PlainXmlModel();
        catalogue2.setName("Catalogue2");
        catalogue2.getAliases().add("In");
        catalogue2.setFile(model2Path.toFile());
        catalogue2.load();

        PlainXmlModel merged = new PlainXmlModel();
        merged.setName("Merged");
        merged.setReadOnLoad(false);
        merged.load();

        moduleEcl.getContext().getModelRepository().addModels(catalogue1, catalogue2);
        moduleEcl.execute();

        // We can it matched by making sure the model did not return null
        System.out.println(moduleEcl.getContext().getMatchTrace().getReduced() != null);

        module.getContext().getModelRepository().addModels(catalogue1, catalogue2, merged);
        module.getContext().setMatchTrace(moduleEcl.getContext().getMatchTrace().getReduced());
        module.execute();
        String data = merged.getXml();


        String mergedData = data;
        System.out.println(mergedData);

        // Delete the temp file after comparing the model
        serviceUtil.deleteFiles(model1Path.toFile(), model1Path.toFile(), eclPath.toFile(), emlPath.toFile());

        return mergedData;

    }
}
