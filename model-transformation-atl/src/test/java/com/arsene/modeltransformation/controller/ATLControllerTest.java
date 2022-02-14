package com.arsene.modeltransformation.controller;

import com.arsene.modeltransformation.service.ATLTransformTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ATLControllerTest {

    /*
     *       We are performing Acceptance Test
     *       We are simply posting what the user would post and expect the results
     *       He would expect
     * */

    @Autowired
    private MockMvc mockMvc;

    String testNumber = "";

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
    void transformArtefacts() throws Exception {
        ATLTransformTest test = new ATLTransformTest();
        MockMultipartFile sourceModel = test.handleFiles(1);
        MockMultipartFile sourceMetaModel = test.handleFiles(2);
        MockMultipartFile targetMetaModel = test.handleFiles(3);
        MockMultipartFile script = test.handleFiles(4);

        try {
            MvcResult result = mockMvc.perform(multipart("/transform/")
                    .file(sourceModel)
                    .file(sourceMetaModel)
                    .file(targetMetaModel)
                    .file(script))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isCreated())
                    .andReturn();

            System.out.println(result.getResponse().getContentAsString());

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }
}