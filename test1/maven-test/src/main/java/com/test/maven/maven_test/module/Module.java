package com.test.maven.maven_test.module;


import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Module")
public class Module {



	@Id
	@GeneratedValue
	private Long id;
	private int moduleOrder;
    private String moduleName;
    private Set<UserModule> userModule;


    
	public Module(String moduleName) {
		this.moduleName = moduleName;
	}

	public Module(String moduleName, int moduleOrder) {
		super();
		this.moduleOrder = moduleOrder;
		this.moduleName = moduleName;
	}
	
	public Module() {
		
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getModuleOrder() {
		return moduleOrder;
	}
	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Set<UserModule> getUserModule() {
		return userModule;
	}

	public void setUserModule(Set<UserModule> userModule) {
		this.userModule = userModule;
	}

}
