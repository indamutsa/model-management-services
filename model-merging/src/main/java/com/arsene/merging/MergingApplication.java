package com.arsene.merging;

import com.arsene.merging.service.FilePersistance;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MergingApplication {

    @Autowired
    private FilePersistance filePersistance;

    public static void main(String[] args) {
        SpringApplication.run(MergingApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        filePersistance.init();
    }
}
