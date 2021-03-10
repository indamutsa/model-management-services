package com.arsene.modelquery.service;

import com.arsene.modelquery.utililties.ServiceUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureMockMvc
@SpringBootTest
public class EpsilonQueryTest {

    /*
     * We are performing UNIT Test
     * We are testing the function decoupled with other functionalities
     *
     * */
    String testNumber = "";

    @Autowired
    private ServiceUtil serviceUtil;

    @Autowired
    private EpsilonQuery epsilonQuery;


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

        MockMultipartFile model = handleFiles(1);
        MockMultipartFile metaModel = handleFiles(2);
        MockMultipartFile script = handleFiles(3);

        try {
            String result = epsilonQuery.runEngine(model, metaModel,script);

            boolean expected = result.contains("HELLO WORLD");

            assertEquals(expected, true);

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
                            "model", "Tree.xmi",
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
                            "metaModel", "Tree.ecore",
                            "application/octet-stream", inputStreamSourceMetaModel);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;

            case 3:

                try {
                    Path script = Paths.get("src/test/TestResources/artifacts/script/Demo.eol");
                    File file = new File(script.toString());
                    InputStream inputStreamScript = new FileInputStream(file);

                    multipartFile = new MockMultipartFile(
                            "script", "Demo.eol",
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