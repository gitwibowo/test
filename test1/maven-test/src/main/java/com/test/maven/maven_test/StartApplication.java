package com.test.maven.maven_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.maven.maven_test.module.Module;
import com.test.maven.maven_test.module.User;
import com.test.maven.maven_test.module.UserModule;
import com.test.maven.maven_test.repository.ModuleRepository;
import com.test.maven.maven_test.repository.UserRepository;

@SpringBootApplication
public class StartApplication {
	
	@Autowired
    private ModuleRepository repository;
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}


	/*
	 * @Bean CommandLineRunner initDatabase(ModuleRepository repository) { return
	 * args -> { repository.save(new Module("PromoCard",new Long("1")));
	 * repository.save(new Module("CategoryCard",new Long("2")));
	 * repository.save(new Module("FlashSaleCard",new Long("3")));
	 * repository.save(new Module("HistoryCard",new Long("4"))); repository.save(new
	 * Module("NewsCard",new Long("5")));
	 * 
	 * };
	 * 
	 * }
	 */
	
	public void run(String...strings) throws Exception {
		User userA = new User("UserA");
		Module moduleA = new Module("CategoryCard");
		UserModule userModule = new UserModule();
		userModule.setUsers(userA);
		userModule.setModules(moduleA);
		userModule.setModuleOrder(2);
		userA.getUserModule().add(userModule);
		repository.save(moduleA);
		userRepository.save(userA);
		
		Module moduleB = new Module("FlashSaleCard");
		UserModule userModuleB = new UserModule();
		userModuleB.setUsers(userA);
		userModuleB.setModules(moduleB);
		userModuleB.setModuleOrder(3);
		userA.getUserModule().add(userModuleB);
		repository.save(moduleB);
		userRepository.save(userA);
		
		Module moduleC = new Module("HistoryCard");
		UserModule userModuleC = new UserModule();
		userModuleC.setUsers(userA);
		userModuleC.setModules(moduleC);
		userModuleC.setModuleOrder(4);
		userA.getUserModule().add(userModuleC);
		repository.save(moduleC);
		userRepository.save(userA);
		
		Module moduleD = new Module("NewCard");
		UserModule userModuleD = new UserModule();
		userModuleD.setUsers(userA);
		userModuleD.setModules(moduleD);
		userModuleD.setModuleOrder(5);
		userA.getUserModule().add(userModuleD);
		repository.save(moduleD);
		userRepository.save(userA);
		
		Module moduleE = new Module("PromoCard");
		UserModule userModuleE = new UserModule();
		userModuleE.setUsers(userA);
		userModuleE.setModules(moduleE);
		userModuleE.setModuleOrder(1);
		userA.getUserModule().add(userModuleE);
		repository.save(moduleE);
		userRepository.save(userA);
	}
}
