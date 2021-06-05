package com.arsene.modeltransformation.utililties;


import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@AutoConfigureMockMvc
@SpringBootTest
class ServiceUtilTest {


    /*
     * We are performing UNIT Test
     * We are testing the function decoupled with other functionalities
     *
     * */
    String testNumber = "";

    @Autowired
    private ServiceUtil serviceUtil;


    /*
     * This function will run before everything runs
     * */
    @BeforeEach
    void setUp() {
        System.out.println(String.format("Starting testing..."));
    }

    /*
     * This function will run when we are done performing a single function
     * */
    @AfterEach
    void tearDown() {
        System.out.println(String.format("Finished testing TEST %S", testNumber));
    }

    @Test
    void handleFileName() {

        testNumber = "ONE";

        // Testing functionality
        try {
            String filename = "hello_world.etl";


            // We intend to have an array telling us if it is a script or model artefact,
            // the returned file should be unique thus different from the original file
            String newFileName = serviceUtil.handleFileName(filename).getFileName().toString();
            assertNotEquals(filename, newFileName);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }

    @Test
    void createEmfModel() {

        testNumber = "TWO";

        // Testing functionality
        try {
            Path modelPath = Paths.get("src/test/TestResources/artifacts/models/Tree.xmi");
            Path metaModelPath = Paths.get("src/test/TestResources/artifacts/metamodels/Tree.ecore");

            // Setting model properties ( name, model path, metamodel path)
            StringProperties property = new StringProperties();
            property.setProperty(EmfModel.PROPERTY_NAME, "Source");
            property.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, String.valueOf(metaModelPath));
            property.setProperty(EmfModel.PROPERTY_MODEL_URI, String.valueOf(modelPath));
            property.setProperty(EmfModel.PROPERTY_READONLOAD, "true");
            property.setProperty(EmfModel.PROPERTY_STOREONDISPOSAL, "false");


            StringProperties sourceProperties = serviceUtil.createEmfModel("Source", modelPath, metaModelPath, "true", "false");

            // Assert the result
            assertEquals(sourceProperties, property);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }
}

