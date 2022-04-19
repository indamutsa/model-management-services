package com.arsene.modeltransformation.utililties;

import org.apache.commons.io.FileUtils;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ServiceUtil {

    /*
     * This is the root folder where we temporally persist the files
     * in order to apply our operations on them.
     * Ideally, afterwards they are deleted
     * */
    private static final Path ROOT = Paths.get("src/main/resources/artifacts");
    private static final Path MODEL_FOLDER = ROOT.resolve("models");
    private static final Path METAMODEL_FOLDER = ROOT.resolve("metamodels");
    private static final Path SCRIPT_FOLDER = ROOT.resolve("script");

    /*
    * This function returns a string property that easily help us
    * to create an EmfModel that can be inject in the transformation engine
    *
    * */
    public StringProperties createEmfModel(String modelName, Path modelPath, Path metaModelPath, String readOnLoad, String storeOnDisposal) {
        // Setting model properties ( name, model path, metamodel path)
        StringProperties property = new StringProperties();
        property.setProperty(EmfModel.PROPERTY_NAME, modelName);
        property.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, String.valueOf(metaModelPath));
        property.setProperty(EmfModel.PROPERTY_MODEL_URI, String.valueOf(modelPath));

        // Configuring the target model properties (model, metamodel)
        /*  READONLOAD: If the model(file) is there, it will not read it or ignore based on the flag indicated  */
        /*  STOREONDISPOSAL: We can read the model but not need to save it, or we save it based on the flag indicated*/
        property.setProperty(EmfModel.PROPERTY_READONLOAD, readOnLoad);
        property.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDisposal);

        return property;
    }



    public String makeFileNameUnique(String filename) {
        // Split the filename to extension and name
        String[] str = filename.split("[.]", 0);

        String randomStr = UUID.randomUUID().toString();

        // We are adding some uuid to make the filename unique
        filename = str[0] + "_" + randomStr + "." + str[1];

        return filename;
    }

    public Path handleFileName(String filename){

        Path outputFile = null;

        // Split the filename to extension and name
        String[] str = filename.split("[.]", 0);

        String randomStr = UUID.randomUUID().toString();

        // We are adding some uiid to make the filename unique
        filename = str[0] + "_" + randomStr + "." + str[1];

        // Check if the filename is a script or a model
        switch (str[1]) {
            case "etl":
                outputFile =  SCRIPT_FOLDER.resolve(filename);
                break;
            case "xmi":
            case "model":
                outputFile =  MODEL_FOLDER.resolve(filename);
                break;
            case "ecore":
            case "emf":
                outputFile =  METAMODEL_FOLDER.resolve(filename);
                break;
            default:
                return null;
        }

        return outputFile;
    }

    // In case we decide to receive multiple files as an array
    public Path[] getModelPaths(ArrayList<Path> filePaths) {

        Path sourceModelPath = null;;
        Path sourceMetaModelPath = null;;
        Path targetMetaModelPath = null;;
        Path etlScriptPath = null;

        int i = 0;

        for (Path filePath : filePaths) {

            String[] str = filePath.toString().split("[.]", 0);

            switch (str[1]) {
                case "xmi":
                case "xml":
                case "model":
                    if (i == 0)
                        sourceModelPath = filePath;
                    else if (i == 1)
                        sourceMetaModelPath = filePath;
                    else if (i == 2)
                        targetMetaModelPath = filePath;
                    i++;
                    break;
                case "etl":
                    etlScriptPath = filePath;
                    break;
            }
        }

        return new Path[]{sourceModelPath, sourceMetaModelPath, targetMetaModelPath, etlScriptPath};
    }

    // Delete the file after running them || They are cashed in the repo anyways
    public void deleteFiles(Path... paths) throws IOException {
        for (Path path : paths)
            Files.deleteIfExists(path);

    }

    public void writeToFile(String filePath){
        try
        {
            String filename= "src/main/resources/artifacts/filenames.txt";

            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            fw.write(filePath +"\n");//appends the string to the file
            fw.close();


        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public void deletePreviousTargetModels(){
        String filename= "src/main/resources/artifacts/filenames.txt";
        String models = "src/main/resources/artifacts/models/";
        String metamodels = "src/main/resources/artifacts/metamodels/";
        String script = "src/main/resources/artifacts/script/";

        try {

            String [] dir = new String[] {models, metamodels, script};

            for(String d: dir)
                Files.walk(Paths.get(d))
                        .filter(Files::isRegularFile)
                        .map(Path::toFile)
                        .forEach(File::delete);

//            // Read file line by line
//            allLines = Files.readAllLines(Paths.get(filename));
//
//            // Copy the array of line to another
//            allLines.forEach(line -> {
//                try {
//                    deleteFiles(Paths.get(line));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            FileUtils.writeLines(new File(filename), null, false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
