package com.arsene.modelcomparison.controller;//

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EclControllerTest extends HandlerInterceptorAdapter {

    /*
    *       We are performing Acceptance Test
    *       We are simply posting what the user would post and expect the results
    *       He would expect
    * */

    String testNumber = "";

    @Autowired
    private MockMvc mockMvc;

    /*
    * This function will run before everything runs
    * */

    @BeforeEach
    void setUp() {
        System.out.println(String.format("\nStarting testing..."));
    }




    /*
    * This function will run when we are done performing a single function
    * */


    @AfterEach
    void tearDown() {
        System.out.println(String.format("Finished testing TEST %S\n", testNumber));
    }

    /*
    * This is our Acceptance testing
    * */

    @Test
    void compareModelArtefacts() throws IOException {
        File file = handleFiles(1);
        File file1 = handleFiles(2);
        File script = handleFiles(3);



        testNumber = "ONE";



        //Testing functionality
        try {


            InputStream inputStreamFirstFile = new FileInputStream(file);
            InputStream inputStreamFirstFile1 = new FileInputStream(file1);
            InputStream inputStreamScriptFile = new FileInputStream(script);

            MockMultipartFile multipartFile = new MockMultipartFile(
                    "files", "catalogue1.xml",
                    "application/xml", inputStreamFirstFile);

            MockMultipartFile multipartFile1 = new MockMultipartFile(
                    "files", "catalogue2.xml",
                    "application/xml", inputStreamFirstFile1);

            MockMultipartFile multipartScriptFile = new MockMultipartFile(
                    "files", "Demo.ecl",
                    "application/octet-stream", inputStreamScriptFile);


            MvcResult result = mockMvc.perform(multipart("/services/ecl/")
                    .file(multipartFile)
                    .file(multipartFile1)
                    .file(multipartScriptFile))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isAccepted())
                    .andReturn();

            System.out.println(result.getResponse().getContentAsString());

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }

    public static File handleFiles(int num){
        Path pathSource = null;
        Path pathDest = null;
        File file = null;



        switch (num){
            case 1:
                pathSource = Paths.get("src/test/TestResources/catalogue1.xml");
                pathDest = Paths.get("src/test/TestResources/test/catalogue1.xml");
                file = new File(pathDest.toString());
                break;
            case 2:
                pathSource = Paths.get("src/test/TestResources/catalogue2.xml");
                pathDest = Paths.get("src/test/TestResources/test/catalogue2.xml");
                file = new File(pathDest.toString());
                break;
            case 3:
                pathSource = Paths.get("src/test/TestResources/Demo.ecl");
                pathDest = Paths.get("src/test/TestResources/test/Demo.ecl");
                file = new File(pathDest.toString());
                break;
        }


        if(!file.exists()) {
            try {
                Files.copy(pathSource, pathDest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


}
