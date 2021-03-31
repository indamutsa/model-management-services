package com.arsene.storageservice.service;

import com.arsene.storageservice.entity.*;
import com.arsene.storageservice.entity.artifacts.MetaModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface PersistenceService {
    Artifact persistArtifact(MultipartFile file,
                             MetaModel metaModel,
                             String artifactType, Project project) throws IOException;
    Artifact getFile(String id);
    Stream<Artifact> getAllFiles();

    void createWorkspace(User user, Workspace workspace);
    void createProject(Project project);
    void createComment(Comment comment);


}
