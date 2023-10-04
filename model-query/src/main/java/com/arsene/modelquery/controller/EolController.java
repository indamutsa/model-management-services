package com.arsene.modelquery.controller;


import com.arsene.modelquery.DTO.DataStr;
import com.arsene.modelquery.DTO.ResponseDto;
import com.arsene.modelquery.service.EpsilonQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
//@RequestMapping(path = "/")
public class EolController {

    @Autowired
    private EpsilonQuery epsilonQuery;

    /*
     * This endpoint compares two models
     * */
    @PostMapping(value = "/query", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity validateArtefact(
            @RequestPart(value = "model") MultipartFile model,
            @RequestPart(value = "metaModel") MultipartFile metaModel,
            @RequestPart(value = "script") MultipartFile script
            ) {

        String message = "Query result: \n";


        try {
            String result = epsilonQuery.runEngine(model, metaModel, script);
            message += result;

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            message = "Model validation failed, please check the error and try again!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }

    /*
     * This endpoint queries a model
     * */
    @PostMapping(value = "/query/str", consumes = "application/json")
    public ResponseEntity validateArtefactStr(
            @RequestBody DataStr[] queryArr, @RequestHeader HttpHeaders headers
    ) {
        String message = "Query result: \n";
        try {
            message += epsilonQuery.runEngineStr(queryArr);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Model validation failed, please check the error and try again!" + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message));
        }
    }
}
