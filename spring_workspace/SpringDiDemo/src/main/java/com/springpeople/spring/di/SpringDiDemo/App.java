package com.springpeople.spring.di.SpringDiDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springpeople.spring.di.SpringDiDemo.config.AppConfig;
//import com.springpeople.spring.di.SpringDiDemo.model.Books;
import com.springpeople.spring.di.SpringDiDemo.service.BooksService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BooksService b = ctx.getBean(BooksService.class);
        b.showBookDetails();
        ctx.close();
    }
}
