package com.demoproject.JavaBasedConfigDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =  new AnnotationConfigApplicationContext(ApplicationConfig.class);
        SamsungPhone phone = context.getBean(SamsungPhone.class);
        phone.specs();
    }
}
