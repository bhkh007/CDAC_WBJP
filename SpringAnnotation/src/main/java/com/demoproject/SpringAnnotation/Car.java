package com.demoproject.SpringAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	
	@Autowired
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
		
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("This is a Car");
		System.out.println("This is a Engine " + engine);
		
	}
	
}

