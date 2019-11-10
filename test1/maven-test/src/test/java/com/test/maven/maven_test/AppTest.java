package com.test.maven.maven_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.maven.maven_test.controller.ModuleController;
import com.test.maven.maven_test.module.Module;
import com.test.maven.maven_test.module.User;
import com.test.maven.maven_test.module.UserModule;
import com.test.maven.maven_test.repository.ModuleRepository;
import com.test.maven.maven_test.repository.UserRepository;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
{
	
	@Autowired
	UserRepository userRepository;
	ModuleController controller;
	ModuleRepository repository;
 
    public void testApp()
    {
    	User user1 = new User("UserB");
		Module module1 = new Module("FlashSaleCard");
    	
		UserModule userModule = new UserModule();
		userModule.setUsers(user1);
		userModule.setModules(module1);
		userModule.setModuleOrder(1);
		user1.getUserModule().add(userModule);
		repository.save(module1);
		userRepository.save(user1);
		
		List<Module> modulesResult = controller.getUserModule(user1.getId());
		
		assertThat(modulesResult.get(0).getModuleOrder()).isEqualTo(1);
    }
}
