package com.arsene.metamodel.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.arsene.metamodel.metric.service.FilePersistance;

@SpringBootApplication
public class ModelTransformationApplication {

    @Autowired
    private FilePersistance filePersistance;

    public static void main(String[] args) {
        SpringApplication.run(ModelTransformationApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        filePersistance.init();
    }
}
