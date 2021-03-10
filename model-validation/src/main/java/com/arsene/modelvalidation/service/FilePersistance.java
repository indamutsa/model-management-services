package com.arsene.modelvalidation.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public interface FilePersistance {
    public void init();
    public Path saveFile(MultipartFile file);
    public Resource loadFile(Path dir);
    public void deleteAll(Path dir);
    public Stream<Path> loadAllFiles(Path dir);

    public Path[] saveFile(MultipartFile model,
                           MultipartFile metaModel,
                           MultipartFile script);
}
