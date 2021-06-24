package com.arsene.modelcomparison.controller;


import com.arsene.modelcomparison.DTO.ResponseDto;
import com.arsene.modelcomparison.service.EpsilonCompare;
import com.arsene.modelcomparison.service.FilePersistance;
import com.arsene.modelcomparison.utililties.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;


@RestController
@RequestMapping(path = "/compare")
public class EclController {

    @Autowired
    private EpsilonCompare epsilonCompare;

    @Autowired
    private FilePersistance filePersistance;

    @Autowired
    private ServiceUtil serviceUtil;


    /*
    * This endpoint compares two models
    * */
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity compareModelArtefacts(@RequestPart(value = "files") MultipartFile[] files) {

        String message = "Comparing models...";
        ArrayList<Path> filePaths = new ArrayList<>();
        ArrayList<String> fileNames = new ArrayList<>();

        boolean match = false;

        Arrays.asList(files)
                .stream()
                .forEach(file -> {
                    // Saving the file in the fileSystem
                    Path filePath = filePersistance.saveFile(file);
                    filePaths.add(filePath);
                    fileNames.add(file.getOriginalFilename());
                });



        String[] names = serviceUtil.getModelNames(fileNames);
        message = message + names[0] + ", " + names[1];

        try {
            match = epsilonCompare.runEngine(filePaths);

            if (match)
                message = message + ": MATCHED";
            else
                message = message + ": UNMATCHED";

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);

        } catch (Exception e) {
            message = "Failed to perform comparison... : " + names[0] + ", " + names[1];
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e);
        }
    }
}