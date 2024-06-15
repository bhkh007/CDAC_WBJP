package com.maven.SpringXMLDemo;

public class Car implements Vehicle{
	
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
		
	}

	
	
}
