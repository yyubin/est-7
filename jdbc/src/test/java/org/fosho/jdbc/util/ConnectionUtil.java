package org.fosho.jdbc.util;

// JDBC
// Java Database Connectivity

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static class MysqlConnectionConstant {
        public static final String URL = "jdbc:mysql://localhost:3307/est_jdbc";
        public static final String USER = "cassidy";
        public static final String PASSWORD = "65";
    }

    public static class H2ConnectionConstant {
        public static final String URL = "jdbc:h2:./est";
        public static final String USER = "sa";
        public static final String PASSWORD = "";
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    MysqlConnectionConstant.URL, MysqlConnectionConstant.USER, MysqlConnectionConstant.PASSWORD
            );
//            return DriverManager.getConnection(
//                    H2ConnectionConstant.URL, H2ConnectionConstant.USER, H2ConnectionConstant.PASSWORD
//            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
