package com.test.maven.maven_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.maven.maven_test.module.User;


public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAllUsers();
	List<User> findByUsers_UserName(String userName);
}
