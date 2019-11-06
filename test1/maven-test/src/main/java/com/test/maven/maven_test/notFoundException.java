package com.test.maven.maven_test;

public class notFoundException extends RuntimeException {

	public notFoundException(Long moduleOrder) {
		super("ModuleOrder not found : " + moduleOrder);
	}

}
