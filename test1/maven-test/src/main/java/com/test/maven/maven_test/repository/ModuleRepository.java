package com.test.maven.maven_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.maven.maven_test.module.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}

