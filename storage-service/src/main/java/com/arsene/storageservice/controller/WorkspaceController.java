package com.arsene.storageservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WorkspaceController {


    @PostMapping("/workspace")
    public String createWorkspace(String name){
        return null;
    }

    @GetMapping("/workspace/{name}")
    public String getWorkspaceByName(@PathVariable("name") String name){
        return null;
    }

    @GetMapping("/workspace/{id}")
    public String getWorkspaceById(@PathVariable("id") String id){
        return null;
    }

    @PutMapping("/workspace/{name}")
    public String updateWorkspaceName(@PathVariable("name") String name){
        return null;
    }

    @DeleteMapping("/workspace/{id}")
    public boolean deleteWorkspaceById( @PathVariable("id")  long id){
        return false;
    }

    @DeleteMapping("/workspace/{name}")
    public boolean deleteWorkspaceByName(@PathVariable("name")  String name){
        return false;
    }

    // -----------------------------------------------------------------------

    @PostMapping("/project")
    public String createProject(String name){
        return null;
    }

    @GetMapping("/project/{name}")
    public String getProjectByName(@PathVariable("name") String name){
        return null;
    }

    @GetMapping("/project/{id}")
    public String getProjectById(@PathVariable("id") long id){
        return null;
    }

    @PutMapping("/project/{name}")
    public String updateProjectByName(@PathVariable("name") String name){
        return null;
    }

    @DeleteMapping("/project/{id}")
    public boolean deleteProjectById(@PathVariable("id")  long id){
        return false;
    }

    @DeleteMapping("/project/{name}")
    public boolean deleteProjectByName(@PathVariable("name") String name){
        return false;
    }
}
