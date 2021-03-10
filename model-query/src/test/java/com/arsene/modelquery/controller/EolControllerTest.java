package com.arsene.modelquery.controller;

import com.arsene.modelquery.service.EpsilonQueryTest;
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
@SpringBootTest
class EolControllerTest {

    /*
     *       We are performing Acceptance Test
     *       We are simply posting what the user would post and we expect
     *       what the user would expect as the results
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
     * This function will run when we are done performing a single test
     * */


    @AfterEach
    void tearDown() {
        System.out.println(String.format("Finished testing TEST %S\n", testNumber));
    }

    /*
     * This is our Acceptance testing
     * */

    @Test
    void validateArtefact() {
        EpsilonQueryTest test = new EpsilonQueryTest();
        MockMultipartFile model = test.handleFiles(1);
        MockMultipartFile metaModel = test.handleFiles(2);
        MockMultipartFile script = test.handleFiles(3);

        try {
            MvcResult result = mockMvc.perform(multipart("/services/eol/")
                    .file(model)
                    .file(metaModel)
                    .file(script))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(status().isOk())
                    .andReturn();

            System.out.println(result.getResponse().getContentAsString());

            System.out.println(String.format("Test ---> %s passed successfully!", testNumber));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Test %s failed: " + e.getMessage(), testNumber));
        }
    }
}