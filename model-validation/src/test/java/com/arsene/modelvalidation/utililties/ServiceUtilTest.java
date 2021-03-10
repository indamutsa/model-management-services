package com.arsene.modelvalidation.utililties;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.evl.EvlModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

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
    void createEmfModel() {

        testNumber = "ONE";

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

    @Test
    void isParsed() {
        testNumber = "TWO";

        Path scriptPath = Paths.get("src/test/TestResources/artifacts/script/Demo.evl");
        EvlModule eclModule = new EvlModule();

        // We are mocking the parsed module
        try {
            eclModule.parse(scriptPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing functionality
        try {
            EvlModule module = serviceUtil.isParsed(scriptPath);
            assertEquals(eclModule, module);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }

    @Test
    void handleFileName() {

        testNumber = "THREE";

        // Testing functionality
        try {
            String filename = "hello_world.txt";
            String new_filename = serviceUtil.makeFileNameUnique(filename);

            // We intend to have these files different after making it unique
            assertNotEquals(filename, new_filename);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }
}