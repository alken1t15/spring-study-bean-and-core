package org.example;

import org.example.database.ConnectionPool;
import org.springframework.stereotype.Component;

public class UserRepository {

    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
