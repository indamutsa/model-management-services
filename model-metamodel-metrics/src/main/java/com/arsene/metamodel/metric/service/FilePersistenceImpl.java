package com.arsene.metamodel.metric.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.arsene.metamodel.metric.utililties.ServiceUtil;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilePersistenceImpl implements FilePersistance {

    @Autowired
    private ServiceUtil serviceUtil;

    /*
     * This is the root folder where we temporally persist the files
     * in order to apply our operations on them.
     * Ideally, afterwards they are deleted
     * */
    private static final Path ROOT = Paths.get("src/main/resources/artifacts");
    private static final Path MODEL_FOLDER = ROOT.resolve("models");
    private static final Path METAMODEL_FOLDER = ROOT.resolve("metamodels");
    private static final Path SCRIPT_FOLDER = ROOT.resolve("script");

    /*
     * Store(file): receives MultipartFile object,
     * transform to FileBD Object and save it to Database
     * */
    @Override
    public void init() {
        try {
            if (Files.exists(ROOT) ) {
                System.out.println("Files exists!\nNumber of folders: " + Files.list(ROOT).count());
                return;
            }


            while (!Files.exists(ROOT)) {
                Files.createDirectory(ROOT);
                Files.createDirectory(MODEL_FOLDER);
                Files.createDirectory(METAMODEL_FOLDER);
                Files.createDirectory(SCRIPT_FOLDER);
                Files.createFile(Path.of("src/main/resources/artifacts/filenames.txt"));
                System.out.println("Waiting creation of the folders!");
            }

            System.out.println("Number of folders: " + Files.list(ROOT).count());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create upload folder");
        }
    }

    /*
     * Save the file in the filesystem | not in the database
     * The filesystem is a temporal buffer where we persist
     * data while we executing the operations | In case we want to persist them appropriately
     * We use the storage component (MDEForge)
     * */
    @Override
    public Path saveFile(MultipartFile file) {

        Path dir = serviceUtil.handleFileName(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), dir);
            File f = new File(dir.toUri());

            while (!f.exists()) {
                System.out.println("Waiting the file to be created....");
            }

            return dir;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    public Path[] saveFile(MultipartFile sourceModel, MultipartFile sourceMetaModel, MultipartFile targetMetaModel, MultipartFile etlScript) {
        Path sourceModelPath = saveFile(sourceModel);
        Path sourceMetaModelPath = saveFile(sourceMetaModel);
        Path targetMetaModelPath = saveFile(targetMetaModel);
        Path etlScriptPath = saveFile(etlScript);

        return new Path[]{sourceModelPath, sourceMetaModelPath, targetMetaModelPath, etlScriptPath};
    }

    /*
     * Load the file from the filesystem
     * */
    @Override
    public Resource loadFile(Path dir) {
        try {
            Resource resource = new UrlResource(dir.toUri());

            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new RuntimeException("Could not read the file");

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll(Path dir) {
        FileSystemUtils.deleteRecursively(dir.toFile());
    }

    /*
     * Load all the files from the file system
     * */
    @Override
    public Stream<Path> loadAllFiles(Path dir) {
        try {
            return Files.walk(dir, 1)
                    .filter(path -> !path.equals(dir))
                    .map(dir::relativize);

        } catch (IOException e) {
            throw new RuntimeException("Could not load the files: " + e.getMessage());
        }
    }
}