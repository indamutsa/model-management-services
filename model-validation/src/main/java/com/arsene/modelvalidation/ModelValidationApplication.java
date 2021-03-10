package com.arsene.modelvalidation;

import com.arsene.modelvalidation.service.FilePersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ModelValidationApplication {

    @Autowired
    private FilePersistance filePersistance;

    public static void main(String[] args) {
        SpringApplication.run(ModelValidationApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        filePersistance.init();
    }
}
