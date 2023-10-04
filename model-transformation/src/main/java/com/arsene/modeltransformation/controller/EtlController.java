package com.arsene.modeltransformation.controller;

import com.arsene.modeltransformation.DTO.DataStr;
import com.arsene.modeltransformation.DTO.LogOperation;
import com.arsene.modeltransformation.DTO.ResponseDto;
import com.arsene.modeltransformation.DTO.TransData;
import com.arsene.modeltransformation.service.EpsilonTransform;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@CrossOrigin
@RequestMapping(path = "/transform")
public class EtlController {

    @Autowired
    private EpsilonTransform epsilonTransform;
    private LogOperation logOperation;
    private RestTemplate restTemplate;

    TransData transModel = null;
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
            @RequestPart(value = "etlScript") MultipartFile etlScript,
            @RequestHeader HttpHeaders headers
    ) {
        InetSocketAddress host = headers.getHost();
//        178.238.238.209
//        String urlHost = "http://178.238.238.209"; //host.getHostName(); //+ ":" + host.getPort();
        // String urlHost = "https://178.238.238.209.sslip.io/repo"; //host.getHostName(); //+ ":" + host.getPort();
        String urlHost = "http://persistence-api:3200"; //host.getHostName(); //+ ":" + host.getPort();

        String transformedStr = "";


        String message = "Model transformation failed, please check the error and try again!";

        try {
            transformedModel = epsilonTransform.runEngine(sourceModel, sourceMetaModel, targetMetaModel, etlScript);

            try (Reader reader = new InputStreamReader(transformedModel.getInputStream(), UTF_8)) {
                transformedStr = FileCopyUtils.copyToString(reader);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }


            // Todo ==> Persist the operation
            // We are going to persist the operation metadata such as the names of the model resources
            // Persist the artifact
            logOperation = new LogOperation(sourceModel, sourceMetaModel, targetMetaModel, etlScript);
//            String url = urlHost + ":3200/store/operation";
            String url = urlHost + "/store/operation";

            // ----------------------------------------------------------------------
//            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // This nested HttpEntiy is important to create the correct
            // Content-Disposition entry with metadata "name" and "filename"
            MultiValueMap<String, String> smFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> smmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> tmmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> dslFileMap = new LinkedMultiValueMap<>();

            ContentDisposition contentDisposition = ContentDisposition
                    .builder("form-data")
                    .name("sourceM")
                    .filename(sourceModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition1 = ContentDisposition
                    .builder("form-data")
                    .name("sourceMM")
                    .filename(sourceMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition2 = ContentDisposition
                    .builder("form-data")
                    .name("targetMM")
                    .filename(targetMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition3 = ContentDisposition
                    .builder("form-data")
                    .name("script")
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

            body.add("sourceM", sourceModelEntity);
            body.add("sourceMM", sourceMetaModelEntity);
            body.add("targetMM", targetMetaModelEntity);
            body.add("script", scriptEntity);

            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class);
            System.out.println("******************************");

            return ResponseEntity.status(HttpStatus.CREATED).body(transformedStr);

//          ResponseEntity response = restTemplate.exchange("http://localhost:3200/store/operation", HttpMethod.POST, httpEntity, String.class);
//          System.out.println("***************************************#################");
        } catch (
                Exception e) {
            if (transformedStr != null) {
//                System.out.println( "*************"+e);
                return ResponseEntity.status(HttpStatus.CREATED).body("Did not persist the operation" + "\n\n" + transformedStr);
            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(e.getMessage()));
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message + "  " + e.getMessage()));
        }
    }

    @PostMapping(value = "/str", consumes = "application/json")
    public ResponseEntity transformArtefactsStr(
            @RequestBody DataStr[] transArr, @RequestHeader HttpHeaders headers
    ) {

        InetSocketAddress host = headers.getHost();
//        178.238.238.209
//        String urlHost = "http://178.238.238.209"; //host.getHostName(); //+ ":" + host.getPort();
        // String urlHost = "https://178.238.238.209.sslip.io/repo";
        String urlHost = "http://persistence-api:3200";
        String transformedStr = "";//

        String message = "Model transformation failed, please check the error and try again!";

        try {
            transModel = epsilonTransform.runEngineStr(transArr);//
            MultipartFile sourceModel = transModel.getSourceModel();
            MultipartFile sourceMetaModel = transModel.getSourceMetaModel();
            MultipartFile targetMetaModel = transModel.getTargetMetaModel();
            MultipartFile etlScript = transModel.getEtlScript();

            try (Reader reader = new InputStreamReader(transModel.getResource().getInputStream(), UTF_8)) {
                transformedStr = FileCopyUtils.copyToString(reader);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

            // Todo ==> Persist the operation
            // We are going to persist the operation metadata such as the names of the model resources
            // Persist the artifact
            logOperation = new LogOperation(sourceModel, sourceMetaModel, targetMetaModel, etlScript);
//          String url = urlHost + ":3200/store/operation";
            String url = urlHost + "/store/operation";
            // ----------------------------------------------------------------------
//            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // This nested HttpEntiy is important to create the correct
            // Content-Disposition entry with metadata "name" and "filename"
            MultiValueMap<String, String> smFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> smmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> tmmFileMap = new LinkedMultiValueMap<>();
            MultiValueMap<String, String> dslFileMap = new LinkedMultiValueMap<>();

            ContentDisposition contentDisposition = ContentDisposition
                    .builder("form-data")
                    .name("sourceM")
                    .filename(sourceModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition1 = ContentDisposition
                    .builder("form-data")
                    .name("sourceMM")
                    .filename(sourceMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition2 = ContentDisposition
                    .builder("form-data")
                    .name("targetMM")
                    .filename(targetMetaModel.getOriginalFilename())
                    .build();
            ContentDisposition contentDisposition3 = ContentDisposition
                    .builder("form-data")
                    .name("script")
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

            body.add("sourceM", sourceModelEntity);
            body.add("sourceMM", sourceMetaModelEntity);
            body.add("targetMM", targetMetaModelEntity);
            body.add("script", scriptEntity);

            HttpEntity<MultiValueMap<String, Object>> requestEntity =
                    new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class);

            return ResponseEntity.status(HttpStatus.CREATED).body(transformedStr);

////          ResponseEntity response = restTemplate.exchange("http://localhost:3200/store/operation", HttpMethod.POST, httpEntity, String.class);
////          System.out.println("***************************************#################");
        } catch (Exception e) {
            if (transformedStr != null) {
                System.out.println("*************" + e);
                return ResponseEntity.status(HttpStatus.CREATED).body("Did not persist the operation" + "\n\n" + transformedStr);
            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(e.getMessage()));
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(message + "  " + e.getMessage()));
        }
    }
}
