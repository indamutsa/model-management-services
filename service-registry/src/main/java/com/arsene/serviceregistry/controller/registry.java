package com.arsene.serviceregistry.controller;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class registry {
    @RestController
    public class ServiceController {
        @GetMapping("/registered-services")
        public ResponseEntity getInstances(){
            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();
            ServiceProperty serviceProperty = new ServiceProperty();
            List<ServiceProperty> instances = new ArrayList<ServiceProperty>();
            var list = new ArrayList();


            for(var app : applications.getRegisteredApplications()){
                list.add(app.getInstancesAsIsFromEureka());
            }
            System.out.println(list);

            return new ResponseEntity(list, HttpStatus.OK);
        }
    }

}
