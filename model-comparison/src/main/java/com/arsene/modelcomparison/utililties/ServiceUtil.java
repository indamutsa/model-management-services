package com.arsene.modelcomparison.utililties;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.ecl.EclModule;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class ServiceUtil {

    public EclModule isParsed(Path scriptPath) throws Exception {

        EclModule module =  module = new EclModule();

        boolean isParsed = module.parse(scriptPath);

//        System.out.println("Passed: " + isParsed);

        //In case there is parser errors, print them
        if (!isParsed) {
            module = null;
            for (ParseProblem problem : module.getParseProblems())
                System.err.println(problem.toString());
        }
        return module;
    }

    public String makeFileNameUnique(String filename) {
        // Split the filename to extension and name
        String[] str = filename.split("[.]", 0);

        String randomStr = UUID.randomUUID().toString();

        // We are adding some uuid to make the filename unique
        filename = str[0] + "_" + randomStr + "." + str[1];

        return filename;
    }

    public Object[] handleFileName(String filename) {
        boolean isScript = false;

        // Split the filename to extension and name
        String[] str = filename.split("[.]", 0);

        String randomStr = UUID.randomUUID().toString();

        // We are adding some uiid to make the filename unique
        filename = str[0] + "_" + randomStr + "." + str[1];

        // Check if the filename is a script or a model
        isScript = str[1].equals("ecl") ? true : false;

        return new Object[]{isScript, filename};
    }

    public Path[] getModelPaths(ArrayList<Path> filePaths) {
//        String str = "";
        Path modelPath1 = null;
        Path modelPath2 = null;
        Path scriptPath = null;

        int i = 0;


        for (Path filePath : filePaths) {

            String[] str = filePath.toString().split("[.]", 0);

            switch (str[1]) {
                case "xmi":
                case "xml":
                case "model":
                    if (i == 0)
                        modelPath1 = filePath;
                    else
                        modelPath2 = filePath;
                    i++;
                    break;
                case "ecl":
                    scriptPath = filePath;
                    break;
            }
        }

        return new Path[]{modelPath1, modelPath2, scriptPath};
    }

    // Delete the file after running them || They are cashed in the repo anyways
    public void deleteFiles(File... files) {
        for (File f : files)
            f.delete();
    }

    public String[] getModelNames(ArrayList<String> names) {
        int i = 0;
        String modelName1 = "";
        String modelName2 = "";

        for (String fileName : names) {
            if (!fileName.split("[.]", 0)[1].equals("ecl"))
                if (i == 0)
                    modelName1 = fileName;
                else
                    modelName2 = fileName;
                i++;

        }
        return new String[]{modelName1, modelName2};
    }
}
