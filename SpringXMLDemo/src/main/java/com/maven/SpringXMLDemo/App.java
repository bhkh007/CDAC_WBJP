package com.maven.SpringXMLDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	Vehicle vh = (Vehicle) context.getBean("vehicle");
    	vh.run();
    	
    }
}
