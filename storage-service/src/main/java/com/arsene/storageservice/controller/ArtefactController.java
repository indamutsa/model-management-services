package com.arsene.storageservice.controller;

import com.arsene.storageservice.DTO.ArtifactDto;
import com.arsene.storageservice.entity.Artifact;
import com.arsene.storageservice.entity.artifacts.MetaModel;
import com.arsene.storageservice.entity.artifacts.Model;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/services/store/artifact")
public class ArtefactController {
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String createArtefact( @RequestPart(value = "artifact") MultipartFile artifact){
        return null;
    }

    @GetMapping("/{name}")
    public String getArtefactByName(@PathVariable("name") String name){
        return null;
    }

    @GetMapping("/{id}")
    public String getArtefactById(@PathVariable("id") long id){
        return null;
    }

    @PutMapping("/artifact")
    public String updateArtefact(ArtifactDto artifact){
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean deleteArtefactById(@PathVariable("id") long id){
        return false;
    }

    @DeleteMapping("/{name}")
    public boolean deleteArtefactByName(@PathVariable("name") String name){
        return false;
    }

    // -----------------------------------------------------------------------

    @PostMapping(value = "/model", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String createModel( @RequestPart(value = "model") MultipartFile model){
        return null;
    }

    @PostMapping("/model-metamodel")
    public String createModel(@PathVariable Model model, MetaModel metaModel){
        return null;
    }

    @GetMapping("/model/{name}")
    public String getModelByName(@PathVariable("name") String name){
        return null;
    }

    @GetMapping("/model/{id}")
    public String getModelById(@PathVariable("id") long id){
        return null;
    }

    @PutMapping("/model/{id}")
    public String updateModelById(@PathVariable("id") long id, Model model){
        return null;
    }

    @PutMapping("/model/{name}")
    public String updateModelByName(@PathVariable("name") String name, Model model){
        return null;
    }

    @DeleteMapping("/model/{id}")
    public boolean deleteModelById(@PathVariable("id") long id){
        return false;
    }

    @DeleteMapping("/model/{name}")
    public boolean deleteModelByName(@PathVariable("name") String name){
        return false;
    }

    // -----------------------------------------------------------------------

    @PostMapping(value = "/metamodel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String createMetaModel(@RequestPart(value = "metamodel") MultipartFile metamodel){
        return null;
    }

    @GetMapping("/metamodel/{id}")
    public String getMetaModelById(@PathVariable("id") long id){
        return null;
    }

    @GetMapping("/metamodel/{name}")
    public String getMetaModelByName(@PathVariable("name") String name){
        return null;
    }

    @PutMapping("/metamodel/{id}")
    public String updateMetaModelById(@PathVariable("id") long id, MetaModel metaModel){
        return null;
    }

    @PutMapping("/metamodel/{name}")
    public String updateMetaModelByName(@PathVariable("name") String name, MetaModel metaModel){
        return null;
    }

    @DeleteMapping("/metamodel/{id}")
    public boolean deleteMetaModelById(@PathVariable("id") long id){
        return false;
    }

    @DeleteMapping("/metamodel/{name}")
    public boolean deleteMetaModelByName(@PathVariable("name") String name){
        return false;
    }

    // -----------------------------------------------------------------------


    @PostMapping(value = "/dsl", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String persistDsl(@RequestPart(value = "dsl") MultipartFile dsl){
        return null;
    }

    @GetMapping("/dsl/{id}")
    public String getDslById(@PathVariable("id") long id){
        return null;
    }

    @GetMapping("/dsl/{name}")
    public String getDslByName(@PathVariable("name") String name){
        return null;
    }

    @PutMapping("/dsl/{id}")
    public String updateDslById(@PathVariable("id") long id, MetaModel metaModel){
        return null;
    }

    @PutMapping("/dsl/{name}")
    public String updateDslByName(@PathVariable("name") String name, MetaModel metaModel){
        return null;
    }

    @DeleteMapping("/dsl/{id}")
    public boolean deleteDslById(@PathVariable("id") long id){
        return false;
    }

    @DeleteMapping("/dsl/{name}")
    public boolean deleteDslByName(@PathVariable("name") String name){
        return false;
    }

    // -----------------------------------------------------------------------
}
