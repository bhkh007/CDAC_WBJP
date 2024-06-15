package com.demoproject.JavaBasedConfigDemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Mac implements Processor {

	
	public void process() {
		
		System.out.println("MAC : The bext processor in world");

	}

}
