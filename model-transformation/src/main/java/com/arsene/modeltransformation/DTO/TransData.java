package com.arsene.modeltransformation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransData {
    private Resource resource;
    private MultipartFile sourceModel;
    private MultipartFile sourceMetaModel;
    private MultipartFile targetMetaModel;
    private MultipartFile etlScript;
}
