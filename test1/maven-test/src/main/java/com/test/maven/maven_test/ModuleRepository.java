package com.test.maven.maven_test;

import org.springframework.data.jpa.repository.JpaRepository;
	
	public interface ModuleRepository extends JpaRepository<Module, Long> {
		
	}

