package com.arsene.modeltransformation.controller;

import com.arsene.modeltransformation.DTO.LogOperation;
import com.arsene.modeltransformation.DTO.ResponseDto;
import com.arsene.modeltransformation.service.EpsilonTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/transform")
public class EtlController {

    @Autowired
    private EpsilonTransform epsilonTransform;
    private LogOperation logOperation;
    private RestTemplate restTemplate;

    Resource transformedModel = null;

    public EtlController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

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
//            transformedModel = epsilonTransform.runEngine(sourceModel, sourceMetaModel, targetMetaModel, etlScript);


            // Todo ==> Persist the operation
            // We are going to persist the operation metadata such as the names of the model resources
            // Persist the artifact
            logOperation = new LogOperation(sourceModel, sourceMetaModel, targetMetaModel, etlScript);
            String url = "http://localhost:3200/store/operation";

            // ----------------------------------------------------------------------
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // This nested HttpEntiy is important to create the correct
            // Content-Disposition entry with metadata "name" and "filename"
            MultiValueMap<String, String> smFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> smmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> tmmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> dslFileMap = new LinkedMultiValueMap<>();

            ContentDisposition contentDisposition = ContentDisposition
                    .builder("form-data")
                    .name("file")
                    .filename(sourceModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition1 = ContentDisposition
                    .builder("form-data")
                    .name("file")
                    .filename(sourceMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition2 = ContentDisposition
                    .builder("form-data")
                    .name("file")
                    .filename(targetMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition3 = ContentDisposition
                    .builder("form-data")
                    .name("file")
                    .filename(etlScript.getOriginalFilename())
                    .build();


            smFileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
            smmFileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition1.toString());
            tmmFileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition2.toString());
            dslFileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition3.toString());


            HttpEntity<byte[]> sourceModelEntity = new HttpEntity<>(sourceModel.getBytes(), smFileMap);
            HttpEntity<byte[]> sourceMetaModelEntity = new HttpEntity<>(sourceMetaModel.getBytes(), smmFileMap);
            HttpEntity<byte[]> targetMetaModelEntity = new HttpEntity<>(targetMetaModel.getBytes(), tmmFileMap);
            HttpEntity<byte[]> scriptEntity = new HttpEntity<>(etlScript.getBytes(), dslFileMap);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

            body.add("file", sourceModelEntity);
            body.add("file", sourceMetaModelEntity);
            body.add("file", targetMetaModelEntity);
            body.add("file", scriptEntity);

            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(body, headers);
            try {
                ResponseEntity<String> response = restTemplate.exchange(
                        "http://localhost:3200/store/operation",
                        HttpMethod.POST,
                        requestEntity,
                        String.class);
                return response;
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
            }

//            ResponseEntity response = restTemplate.exchange("http://localhost:3200/store/operation", HttpMethod.POST, httpEntity, String.class);
//            System.out.println("***************************************#################");


            return ResponseEntity.status(HttpStatus.CREATED).body("Hello world"); //transformedModel);

        } catch (
                Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message + "  " + e.getMessage()));
        }
    }
}
