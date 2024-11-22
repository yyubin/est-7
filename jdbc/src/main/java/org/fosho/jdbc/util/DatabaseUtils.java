package org.fosho.jdbc.util;

import java.sql.*;

public class DatabaseUtils {

    public static Connection getConnection() {
        try {
            return ConnectionUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing ResultSet", e);
            }
        }
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing Statement", e);
            }
        }
    }

    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing PreparedStatement", e);
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing Connection", e);
            }
        }
    }
}
