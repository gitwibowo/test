package com.test.maven.maven_test.module;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue
	private Long Id;
	private String userName;
    private Set<UserModule> userModule;



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName) {
		super();
		this.userName = userName;
		this.userModule  = new HashSet<>();
	}

	public String getUserName() {
		return userName;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@ManyToMany(mappedBy = "users")
	public Set<UserModule> getUserModule() {
		return userModule;
	}

	public void setUserModule(Set<UserModule> userModule) {
		this.userModule = userModule;
	}

	
	
}
