package com.demoproject.JavaBasedConfigDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Intel implements Processor {

	
	public void process() {
		System.out.println("Intel i9 the new genaration processor");
	}

	
}
