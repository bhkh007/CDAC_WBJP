package com.demoproject.JavaBasedConfigDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungPhone {

	@Autowired
	@Qualifier("mac")
	Processor processor;
	
	void specs() {
		System.out.println("8GB RAM SUPER AMOLED DISPLAY");
		
		processor.process();
	}
	
}
