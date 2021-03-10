package com.arsene.modelcomparison.utililties;

import org.eclipse.epsilon.ecl.EclModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
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
    void isParsed() {
        testNumber = "One";

        Path scriptPath = Paths.get("src/test/TestResources/Demo.ecl");
        EclModule eclModule = new EclModule();

        // We are mocking the parsed module
        try {
            eclModule.parse(scriptPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing functionality
        try {
            EclModule module =serviceUtil.isParsed(scriptPath);
            assertEquals(eclModule, module);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }

    @Test
    void makeFileNameUnique() {

        testNumber = "Two";

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

    @Test
    void handleFileName() {
        testNumber = "Three";

        // Testing functionality
        try {
            String filename = "hello_world.ecl";

            Object[] obj = serviceUtil.handleFileName(filename);

            // We intend to have an array telling us if it is a script or model artefact,
            // the returned file should be unique thus different from the original file
            assertEquals(obj[0], true);
            assertNotEquals(obj[1], filename);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }
}