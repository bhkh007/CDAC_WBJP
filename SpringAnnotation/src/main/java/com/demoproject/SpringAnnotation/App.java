package com.demoproject.SpringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	 Vehicle vh = (Vehicle)context.getBean("car");
    	 vh.run();
    }
}
