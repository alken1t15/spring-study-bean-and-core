package org.example;

import org.example.database.CompanyRepository;
import org.example.database.ConnectionPool;
import org.example.database.CrudRepository;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {
     try (
         var context =  new AnnotationConfigApplicationContext()){
         context.register(ApplicationConfiguration.class);
        // System.out.println(context.getBean("driver",String.class));
         context.getEnvironment().setActiveProfiles("web","prod");
         context.refresh();
         System.out.println(context.getBean("pool1",ConnectionPool.class));
//        var companyRepository = context.getBean("companyRepository", CrudRepository.class);
         var companyService = context.getBean(CompanyService.class);
         System.out.println(companyService.findById(1));
     }
//        SpringApplication.run(ApplicationRunner.class, args);
    }
}
