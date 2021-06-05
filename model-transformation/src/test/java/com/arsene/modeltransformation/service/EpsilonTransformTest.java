package com.arsene.modeltransformation.service;



import com.arsene.modeltransformation.utililties.ServiceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
public class EpsilonTransformTest {

    /*
     * We are performing UNIT Test
     * We are testing the function decoupled with other functionalities
     *
     * */
    String testNumber = "";

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private EpsilonTransform epsilonTransform;


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
        testNumber = "TWO";

        MockMultipartFile sourceModel = handleFiles(1);
        MockMultipartFile sourceMetaModel = handleFiles(2);
        MockMultipartFile targetMetaModel = handleFiles(3);
        MockMultipartFile script = handleFiles(4);

        try {
            Resource resource = epsilonTransform.runEngine(sourceModel, sourceMetaModel, targetMetaModel, script);
            boolean isFile = resource.isFile();
            boolean isReadable = resource.isReadable();
            boolean contentLength = resource.contentLength() > 0;

            boolean[] testTrue = {true, true, true};
            boolean[] status = {isFile, isReadable, contentLength};

            assertArrayEquals(status, testTrue);

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }

    public static MockMultipartFile handleFiles(int num){

        MockMultipartFile multipartFile = null;


        switch (num){
            case 1:

                try {
                    Path sourceModel = Paths.get("src/test/TestResources/artifacts/models/Tree.xmi");
                    File file = new File(sourceModel.toString());
                    InputStream inputStreamScriptFile = new FileInputStream(file);

                    multipartFile = new MockMultipartFile(
                            "sourceModel", "Tree.xmi",
                            "application/xmi", inputStreamScriptFile);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case 2:

                try {
                    Path metaModel = Paths.get("src/test/TestResources/artifacts/metamodels/Tree.ecore");
                    File file = new File(metaModel.toString());
                    InputStream inputStreamSourceMetaModel = new FileInputStream(file);

                    multipartFile = new MockMultipartFile(
                            "sourceMetaModel", "Tree.ecore",
                            "application/octet-stream", inputStreamSourceMetaModel);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case 3:



                try {
                    Path targetMetaModel = Paths.get("src/test/TestResources/artifacts/metamodels/Tree.ecore");
                    File file = new File(targetMetaModel.toString());
                    InputStream inputStreamTargetMetaModel = new FileInputStream(file);

                    multipartFile = new MockMultipartFile(
                            "targetMetaModel", "Tree.ecore",
                            "application/octet-stream", inputStreamTargetMetaModel);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            case 4:

                try {
                    Path script = Paths.get("src/test/TestResources/artifacts/script/Demo.etl");
                    File file = new File(script.toString());
                    InputStream inputStreamScript = new FileInputStream(file);

                    multipartFile = new MockMultipartFile(
                            "etlScript", "Demo.etl",
                            "application/octet-stream", inputStreamScript);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return multipartFile;
    }
}