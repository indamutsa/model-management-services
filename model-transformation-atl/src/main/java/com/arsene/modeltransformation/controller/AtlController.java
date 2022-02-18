package com.arsene.modeltransformation.controller;

import java.util.List;

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

import com.arsene.modeltransformation.DTO.Metric;
import com.arsene.modeltransformation.DTO.ResponseDto;
import com.arsene.modeltransformation.service.ATLTransform;

@RestController
@RequestMapping(path = "/transform")
public class AtlController {

    @Autowired
    private ATLTransform atlTransform;

    Resource transformedModel = null;

    /*
     * This endpoint compares two models
     * */
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity transformArtefacts(
            @RequestPart(value = "sourceModel") MultipartFile sourceModel,
            @RequestPart(value = "sourceMetaModel") MultipartFile sourceMetaModel,
            @RequestPart(value = "targetMetaModel") MultipartFile targetMetaModel,
            @RequestPart(value = "atlScript") MultipartFile atlScript
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            transformedModel = atlTransform.execute(sourceModel, sourceMetaModel, targetMetaModel, atlScript);
            return ResponseEntity.status(HttpStatus.CREATED).body(transformedModel);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
    @PostMapping(value = "/metrics", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity calculateMetric(
            @RequestPart(value = "atlScript") MultipartFile atlScript
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            List<Metric> metrics = atlTransform.calculateMetrics(atlScript);
            return ResponseEntity.status(HttpStatus.CREATED).body(metrics);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
}
