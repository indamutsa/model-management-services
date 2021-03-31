package com.arsene.storageservice.service;

import com.arsene.storageservice.entity.*;
import com.arsene.storageservice.entity.artifacts.*;
import com.arsene.storageservice.entity.dsl.SpecificLanguage;
import com.arsene.storageservice.repository.*;
import com.arsene.storageservice.utililties.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class PersistenceServiceImpl implements PersistenceService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArtifactRepository artifactRepository;

    @Autowired
    private ServiceUtil serviceUtil;


    public void createWorkspace(User user, Workspace workspace){
        userRepository.save(user);
        workspaceRepository.save(workspace);
    }

    public void createProject(Project project){
        projectRepository.save(project);
    }

    public void createComment(Comment comment){
        commentRepository.save(comment);
    }


    public Artifact persistArtifact(MultipartFile file,
                                    MetaModel metaModel,
                                    String artifactType, Project project) throws IOException {

        String fileName = null;
        Artifact artifact = null;

        switch (artifactType){
            case "DSL":
                fileName = StringUtils.cleanPath(file.getOriginalFilename());
                if(!serviceUtil.isTypeValid(fileName, "DSL"))
                    return null;

                artifact = new SpecificLanguage(
                        ArtifactType.DSL,
                        fileName,
                        file.getBytes(),
                        project);
                break;

            case "MODEL":
                fileName = StringUtils.cleanPath(file.getOriginalFilename());
                if(!serviceUtil.isTypeValid(fileName, "MODEL"))
                    return null;

                artifact = new Model(
                        ArtifactType.MODEL,
                        fileName,
                        file.getBytes(),
                        project, metaModel);
                break;

            case "METAMODEL":
                fileName = StringUtils.cleanPath(file.getOriginalFilename());
                if(!serviceUtil.isTypeValid(fileName, "METAMODEL"))
                    return null;

                artifact = new MetaModel(
                        ArtifactType.METAMODEL,
                        fileName,
                        file.getBytes(),
                        project, null);
                break;
        }
        artifactRepository.save(artifact);
        return artifact;
    }

    /*
     * getFile(id): returns a Artifact object by provided Id
     * */
    public Artifact getFile(String id){
        return  artifactRepository.findById(id).get();
    }

    /*
     * getAllFiles(): returns all stored files as list of code>Artifact objects
     * */
    public Stream<Artifact> getAllFiles(){
        return artifactRepository.findAll().stream();
    }

    public String hello(){
        return "Hello world";
    }
}