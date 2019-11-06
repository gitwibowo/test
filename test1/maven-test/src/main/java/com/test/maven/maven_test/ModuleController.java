package com.test.maven.maven_test;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
public class ModuleController {

	@Autowired
    private ModuleRepository repository;
	
	
	// Find
    @GetMapping("/module")
    List<Module> findAll() {
        return repository.findAll();
    }
    
    // Find
    @GetMapping("/module/{moduleOrder}")
    Module findOne(@PathVariable Long moduleOrder) {
        return repository.findById(moduleOrder)
                .orElseThrow(() -> new notFoundException(moduleOrder));
    }
    
    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/module")
    
    Module newModule(@RequestBody Module newModule) {
        return repository.save(newModule);
    }
    
    // Save or update
    @PutMapping("/module/{moduleOrder}")
    Module saveOrUpdate(@RequestBody Module newModule, @PathVariable Long moduleOrder) {

        return repository.findById(moduleOrder)
                .map(x -> {
                    x.setModuleName(newModule.getModuleName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newModule.setModuleOrder(moduleOrder);
                    return repository.save(newModule);
                });
    }
}
