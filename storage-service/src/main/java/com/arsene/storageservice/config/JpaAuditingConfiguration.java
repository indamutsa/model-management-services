package com.arsene.storageservice.config;

import com.arsene.storageservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
    @Autowired
    UserRepository userRepository;

    @Bean
    public AuditorAware<String> auditorProvider(){
        /*
        * if you are using spring security, you can get the currently logged username with following code segment.
        * SecurityContextHolder.getContext().getAuthentication().getName()
        * */
        return () -> Optional.ofNullable(userRepository.findById(1l).get().getName());
    }
}


/*
* https://springbootdev.com/2018/03/13/spring-data-jpa-auditing-with-createdby-createddate-lastmodifiedby-and-lastmodifieddate/
* */