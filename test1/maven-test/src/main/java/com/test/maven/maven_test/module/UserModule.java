package com.test.maven.maven_test.module;

import javax.persistence.*;

@Entity
@Table(name="UserModule")
public class UserModule {

	@Id
	@GeneratedValue
	private Long Id;
	
	private int moduleOrder;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User users;
	
	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Module getModules() {
		return modules;
	}

	public void setModules(Module modules) {
		this.modules = modules;
	}


	@ManyToOne
	@JoinColumn(name = "module_id")
	Module modules;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getModuleOrder() {
		return moduleOrder;
	}

	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}


	public UserModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
