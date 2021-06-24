package com.arsene.merging.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

@Component
public interface FilePersistance {
    public void init();
    public Path[] saveFile(MultipartFile model1, MultipartFile model2, MultipartFile eclScript, MultipartFile emlScript);
    public Path saveFile(MultipartFile file);
    public Resource loadFile(Path dir);
    public void deleteAll(Path dir);
    public Stream<Path> loadAllFiles(Path dir);
}
