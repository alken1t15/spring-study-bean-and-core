package org.example;

import org.example.database.ConnectionPool;
import org.example.database.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Import(WrongThreadException.class)
@Configuration(proxyBeanMethods = true)
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.example.**",
useDefaultFilters = false,
includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Component.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com\\..+Repository")
})
public class ApplicationConfiguration {

    @Bean("pool1")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool1(@Value("{db.username") String username){
        return new ConnectionPool(username,20);
    }
    @Bean("pool2")
    public ConnectionPool pool2(){
        return new ConnectionPool("test-pool",25);
    }

@Bean
    public ConnectionPool pool3(){
        return new ConnectionPool("test-pool",25);
    }

    @Bean
    @Profile("prod")
    public UserRepository userRepository2(@Qualifier("pool2") ConnectionPool pool2){
        return new UserRepository(pool2);
    }

    @Bean
    public UserRepository userRepository3(){
        return new UserRepository(pool3());
    }

}
