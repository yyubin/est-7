package org.fosho.jdbc.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class HikariDataSourceTest {
    @Test
    void hikariDataSourceConnectionTest() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3307/est_jdbc");
        dataSource.setUsername("cassidy");
        dataSource.setPassword("65");
        dataSource.setMaximumPoolSize(5);

        try (Connection conn1 = dataSource.getConnection();
             Connection conn2 = dataSource.getConnection()) {
            System.out.println("Connection 1: " + conn1);
            System.out.println("Connection 2: " + conn2);
        }
        dataSource.close();
    }


}
