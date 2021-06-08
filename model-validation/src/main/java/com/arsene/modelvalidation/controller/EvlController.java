package com.arsene.modelvalidation.controller;


import com.arsene.modelvalidation.DTO.ResponseDto;
import com.arsene.modelvalidation.service.EpsilonValidate;
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
@RequestMapping(path = "/validate")
public class EvlController {

    @Autowired
    private EpsilonValidate epsilonValidate;

    /*
     * This endpoint compares two models
     * */
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity validateArtefact(
            @RequestPart(value = "model") MultipartFile model,
            @RequestPart(value = "metaModel") MultipartFile metaModel,
            @RequestPart(value = "script") MultipartFile script
            ) {

        String message = "Validation result: \n";


        try {
            String result = epsilonValidate.runEngine(model, metaModel, script);
            message += result;

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            message = "Model validation failed, please check the error and try again!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
}
