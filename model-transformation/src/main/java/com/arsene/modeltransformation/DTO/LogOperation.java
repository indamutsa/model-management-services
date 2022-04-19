package com.arsene.modeltransformation.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
public class LogOperation {
    private MultipartFile sourceModel;
    private MultipartFile sourceMetaModel;
    private MultipartFile targetNetaModel;
    private MultipartFile script;



}
