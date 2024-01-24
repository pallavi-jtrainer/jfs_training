package com.springpeople.spring.core.SpringCoreDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springpeople.spring.core.SpringCoreDemo.model.IOCDemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	IOCDemo obj = (IOCDemo)ctx.getBean("demo");
    	System.out.println(obj.getMessage());
    	
    }
}
