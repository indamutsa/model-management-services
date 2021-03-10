package com.arsene.modelcomparison.service;


import com.arsene.modelcomparison.controller.EclControllerTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class EpsilonCompareTest {


    /*
     * We are performing Integration Test
     * We are testing the function coupled with other functionalities
     *
     * */

    String testNumber = "";

    @Autowired
    private EpsilonCompare epsilonCompare;

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
    void runEngine() {
        testNumber = "One";


        File file = EclControllerTest.handleFiles(1);
        File file1 = EclControllerTest.handleFiles(2);
        File script = EclControllerTest.handleFiles(3);

        Path j = Path.of(file.getPath());

        Path scriptPath = Path.of(script.getPath());
        Path model1Path = Path.of(file.getPath());
        Path model2Path = Path.of(file1.getPath());

        ArrayList<Path> paths = new ArrayList<>();
        paths.add(model1Path);
        paths.add(model2Path);
        paths.add(scriptPath);

        boolean status = false;

        // To test this functionality, you need to copy the files in TestResources folder
        // Inside the child folder test, because this function deletes them because they are
        // treated as temp or buffer files

        // Testing functionality
        try {
            status = epsilonCompare.runEngine(paths);
            assertEquals(status, true);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }

    }
}