package org.example.database;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@Component("pool1")
public class ConnectionPool {
    private final   String username;
    private final   Integer poolSize;

//    private  List<Object> args;
//    private  Map<String,Object> properties;
//    private  Map<String,Object> lucky;

    public ConnectionPool(String username, Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }

//    public void setLucky(Map<String, Object> lucky) {
//        this.lucky = lucky;
//    }

    @PostConstruct
    private void init() {
        System.out.println("Init method");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Properties set");
//    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
