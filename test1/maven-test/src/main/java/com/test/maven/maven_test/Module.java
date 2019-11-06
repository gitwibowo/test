package com.test.maven.maven_test;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@JsonRootName(value="modules")
public class Module {

	public Module() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Long moduleOrder;

    private String moduleName;
    
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

    public Long getModuleOrder() {
		return moduleOrder;
	}
	public void setModuleOrder(Long moduleOrder) {
		this.moduleOrder = moduleOrder;
	}
	public Module(String moduleName,Long moduleOrder) {
		super();
		this.moduleOrder = moduleOrder;
		this.moduleName = moduleName;
	}
	
}
