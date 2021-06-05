package com.arsene.modeltransformation.controller;

import com.arsene.modeltransformation.DTO.ResponseDto;
import com.arsene.modeltransformation.service.EpsilonTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "services/etl")
public class EtlController {

    @Autowired
    private EpsilonTransform epsilonTransform;



    Resource transformedModel = null;


    /*
     * This endpoint compares two models
     * */
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity transformArtefacts(
            @RequestPart(value = "sourceModel") MultipartFile sourceModel,
            @RequestPart(value = "sourceMetaModel") MultipartFile sourceMetaModel,
            @RequestPart(value = "targetMetaModel") MultipartFile targetMetaModel,
            @RequestPart(value = "etlScript") MultipartFile etlScript
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            transformedModel = epsilonTransform.runEngine(sourceModel, sourceMetaModel, targetMetaModel, etlScript);
            return ResponseEntity.status(HttpStatus.CREATED).body(transformedModel);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
}
