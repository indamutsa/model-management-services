package com.arsene.metamodel.metric.controller;

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

import com.arsene.metamodel.metric.DTO.Metric;
import com.arsene.metamodel.metric.DTO.QualitiesAndMetrics;
import com.arsene.metamodel.metric.DTO.QualityAttribute;
import com.arsene.metamodel.metric.DTO.ResponseDto;
import com.arsene.metamodel.metric.service.EcoreMetamodelService;

@RestController
@RequestMapping(path = "/metrics")
public class EcoreMetamodelController {

    @Autowired
    private EcoreMetamodelService ecoreService;

    Resource transformedModel = null;

    /*
     * This endpoint compares two models
     * */

    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity calculateMetric(
            @RequestPart(value = "ecoreMetamodel") MultipartFile ecoreMetamodel
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            List<Metric> metrics = ecoreService.calculateMetrics(ecoreMetamodel);
            return ResponseEntity.status(HttpStatus.CREATED).body(metrics);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
    
    @PostMapping(value = "/quality_attributes", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity calculateQualityAttribute(
            @RequestPart(value = "ecoreMetamodel") MultipartFile ecoreMetamodel
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            List<QualityAttribute> qualityAttributes = ecoreService.calculateQualityAttributes(ecoreMetamodel);
            return ResponseEntity.status(HttpStatus.CREATED).body(qualityAttributes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
    
    @PostMapping(value = "/qualities_and_metrics", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity calculateQualitiesAndMetrics(
            @RequestPart(value = "ecoreMetamodel") MultipartFile ecoreMetamodel
            ) {

        String message = "Model transformation failed, please check the error and try again!";

        try {
            QualitiesAndMetrics qualityAttributes = ecoreService.calculateQualitiesAndMetrics(ecoreMetamodel);
            return ResponseEntity.status(HttpStatus.CREATED).body(qualityAttributes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
}
