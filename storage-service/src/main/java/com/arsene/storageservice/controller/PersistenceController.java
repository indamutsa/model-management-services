package com.arsene.storageservice.controller;

import com.arsene.storageservice.entity.Comment;
import com.arsene.storageservice.entity.User;
import com.arsene.storageservice.entity.Workspace;
import com.arsene.storageservice.repository.WorkspaceRepository;
import com.arsene.storageservice.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersistenceController {

    @Autowired
    PersistenceService persistenceService;

    // Todo
    @Autowired
    WorkspaceRepository workspaceRepository;


    @PostMapping("/test/hello")
    @ResponseBody
    public String hello(@RequestBody String incoming_text) {
        System.out.println(incoming_text);
        return incoming_text;
    }

    @GetMapping("/test/repo")
    public ResponseEntity testRepo() {
        User user = new User("arsene", "arsene@gmail.com");
        Workspace workspace = new Workspace("workspace-test", user);

        if (!workspaceRepository.findById(1l).isPresent())
            persistenceService.createWorkspace(user, workspace);
//
//        User user1 = userRepository
//                .findByNameAndEmail("arsene", "arsene!gmail.com").get();
        Workspace workspace1 = workspaceRepository.findById(1l).get();

        Object[] object = { workspace1.getName(), workspace1.getUser().getName(), workspace1.getUser().getEmail() };

        return new ResponseEntity<>(workspace1, HttpStatus.ACCEPTED);
    }

    // -----------------------------------------------------------------------

    @PostMapping("/user")
    public boolean createUser(User user) {
        return false;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return null;
    }

    @GetMapping("/user/{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return null;
    }

    @PutMapping("/user/{name}")
    public User updateUserByName(@PathVariable("name") String name, User user) {
        return null;
    }

    @PutMapping("/user/{id}")
    public User updateUserById(@PathVariable("id") long id, User user) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    public int deleteUserById(@PathVariable("id") long id) {
        return -1;
    }

    @DeleteMapping("/user/{name}")
    public boolean deleteUserByName(@PathVariable("name") String name) {
        return false;
    }

    // -----------------------------------------------------------------------

    @PostMapping("/comment")
    public boolean createComment(Comment comment) {
        return false;
    }

    @GetMapping("/comment/{id}")
    public User getCommentById(@PathVariable("id") long id) {
        return null;
    }

    @GetMapping("/comment/{name}")
    public User getCommentByName(@PathVariable("name") String name) {
        return null;
    }

    @PutMapping("/comment/{name}")
    public User updateCommentByName(String name, Comment comment) {
        return null;
    }

    @PutMapping("/comment/{id}")
    public User updateCommentById(long id, Comment comment) {
        return null;
    }

    @DeleteMapping("/comment/{id}")
    public int deleteCommentById(@PathVariable("id") long id) {
        return -1;
    }

    @DeleteMapping("/comment/{name}")
    public boolean deleteCommentByName(@PathVariable("name") String name) {
        return false;
    }

}
