package com.arsene.modeltransformation.utililties;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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


}

