package org.fosho.jdbc.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(MysqlConnectionConstant.URL);
        config.setUsername(MysqlConnectionConstant.USER);
        config.setPassword(MysqlConnectionConstant.PASSWORD);
        config.setMaximumPoolSize(5);  // 최대 커넥션 풀 사이즈
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static class MysqlConnectionConstant {
        public static final String URL = "jdbc:mysql://localhost:3307/est_jdbc";
        public static final String USER = "cassidy";
        public static final String PASSWORD = "65";
    }

}
