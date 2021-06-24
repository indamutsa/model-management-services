package com.arsene.merging.controller;


import com.arsene.merging.service.EpsilonMerging;
import com.arsene.merging.service.FilePersistance;
import com.arsene.merging.utilities.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(path = "/merge")
public class EmlController {

    @Autowired
    private EpsilonMerging epsilonMerging;

    /*
    * This endpoint compares two models
    * */
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity mergeModelArtefacts(
            @RequestPart(value = "model1") MultipartFile model1,
            @RequestPart(value = "model2") MultipartFile model2,
            @RequestPart(value = "eclScript") MultipartFile eclScript,
            @RequestPart(value = "emlScript") MultipartFile emlScript
    ) {

        String message = "Merging models...";

        try {

            String mergedData = epsilonMerging.runEngine(model1, model2, eclScript, emlScript);
            System.out.println("Finished merging");


            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mergedData);

        } catch (Exception e) {
//            message = "Failed to perform comparison... : " + names[0] + ", " + names[1];
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }
}