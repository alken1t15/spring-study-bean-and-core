package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

    @PostConstruct
    void init(){
        System.out.println("Jpa configuration is enabled");
    }
}
