package com.test.maven.maven_test.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.maven.maven_test.notFoundException;
import com.test.maven.maven_test.module.Module;
import com.test.maven.maven_test.module.User;
import com.test.maven.maven_test.repository.ModuleRepository;
import com.test.maven.maven_test.repository.UserRepository;

import org.springframework.http.HttpStatus;



@RestController
public class ModuleController {

	@Autowired
    private ModuleRepository repository;
	private UserRepository userRepository;
	
	// Find
    @GetMapping("/module")
    List<Module> findAll() {
        return repository.findAll();
    }
    
    @GetMapping("/users")
    List<User> findAllUsers(){
    	return userRepository.findAll();
    }
    
    // Find
    @GetMapping("/module/{moduleOrder}")
    Module findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new notFoundException(id));
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/module")
    Module newModule(@RequestBody Module newModule) {
        return repository.save(newModule);
    }
    
    @PutMapping("/module/{moduleOrder}")
    Module saveOrUpdate(@RequestBody Module newModule, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setModuleName(newModule.getModuleName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newModule.setId(id);
                    return repository.save(newModule);
                });
    }
    

    @GetMapping("getUserModule")
    List <Module> getUserModule(@PathVariable Long userId){
    	return userRepository.findById(userId).get().getUserModule()
				.stream()
				.map(x -> {
					Module m =  x.getModules();
					m.setModuleOrder(x.getModuleOrder());
					return m;
					})
				.collect(Collectors.toList());
    }
}
