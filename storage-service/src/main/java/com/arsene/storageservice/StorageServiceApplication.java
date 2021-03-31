package com.arsene.storageservice;

import com.arsene.storageservice.service.PersistenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootApplication
public class StorageServiceApplication implements CommandLineRunner {

    @Resource
    PersistenceService persister;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(StorageServiceApplication.class, args);

//        PersistenceService persistenceService =  configurableApplicationContext
//                .getBean(PersistenceService.class);
//
//        // --------------------------------------------------------------------------------------
//
//        User user = new User("arsene", "arsene@gmail.com");
//        Workspace workspace = new Workspace("workspace-test", user);
//        Project project = new Project("project-test", workspace);
//        Comment comment = new Comment("First test comment", 2, user, project);
//
//        // --------------------------------------------------------------------------------------
//
//        Path metaModelPath = Paths.get("src/main/resources/artifacts/metamodels/Tree.ecore");
//        File metaModelFile = new File(metaModelPath.toString());
//        InputStream inputStreamMetaModel = new FileInputStream(metaModelFile);
//
//        MultipartFile metaModel = new MockMultipartFile(
//                "MetaModel", "Tree.ecore",
//                "application/octet-stream", inputStreamMetaModel);
//
//        // --------------------------------------------------------------------------------------
//
//        Path modelPath = Paths.get("src/main/resources/artifacts/models/Tree.xmi");
//        File modelFile = new File(modelPath.toString());
//        InputStream inputStreamModel = new FileInputStream(modelFile);
//
//        MultipartFile model = new MockMultipartFile(
//                "Model", "Tree.xmi",
//                "application/octet-stream", inputStreamModel);
//
//        // --------------------------------------------------------------------------------------
//
//        Path dslPath = Paths.get("src/main/resources/artifacts/script/Demo.etl");
//        File dslFile = new File(dslPath.toString());
//        InputStream inputStreamDsl = new FileInputStream(dslFile);
//
//        MultipartFile dsl = new MockMultipartFile(
//                "Dsl", "Demo.etl",
//                "application/octet-stream", inputStreamDsl);
//
//        // --------------------------------------------------------------------------------------
//
//        persistenceService.createWorkspace(user, workspace);
//        persistenceService.createProject(project);
//        persistenceService.createComment(comment);
//
//        MetaModel metaModel1 = (MetaModel)persistenceService.persistArtifact(metaModel, null, "METAMODEL", project);
//        Model model1 = (Model) persistenceService.persistArtifact(model, metaModel1, "MODEL", project);
//        persistenceService.persistArtifact(dsl, null,  "DSL", project);
//        // --------------------------------------------------------------------------------------

    }


    @Override
    public void run(String... args) throws Exception {
//        System.out.println(persister.hello());
    }
}
