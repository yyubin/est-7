package org.fosho.jdbc.connection;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assert;
import org.fosho.jdbc.util.ConnectionUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimerTask;
import java.util.stream.BaseStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
public class ConnectionTests {
    @Test
    @DisplayName("Database Connection Test")
    void connection_test() throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        log.info("connection = {}", connection);
        log.info("connection.getClass() = {}", connection.getClass());
    }

    @Test
    @DisplayName("DriverManager 연결 객체 테스트")
    void driver_manager_connect_test() throws Exception {
       Connection connection1 = DriverManager.getConnection(
               ConnectionUtil.MysqlConnectionConstant.URL, ConnectionUtil.MysqlConnectionConstant.USER, ConnectionUtil.MysqlConnectionConstant.PASSWORD
       );

       Connection connection2 = DriverManager.getConnection(
               ConnectionUtil.H2ConnectionConstant.URL, ConnectionUtil.H2ConnectionConstant.USER, ConnectionUtil.H2ConnectionConstant.PASSWORD
       );

        log.info("connection1.getClass() = {}", connection1.getClass());
        log.info("connection2.getClass() = {}", connection2.getClass());
        assertThat(connection1).isNotEqualTo(connection2);
    }

    @Test
    @DisplayName("DriverManagerDataSource, 커넥션 획득 방법 초기화")
    void datasource_test1() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                ConnectionUtil.MysqlConnectionConstant.URL, ConnectionUtil.MysqlConnectionConstant.USER, ConnectionUtil.MysqlConnectionConstant.PASSWORD
        );
    }

    @Test
    @DisplayName("hikaridatasource connection pooling test")
    void hikari_datasource_connection_pooling_test() throws Exception {
        HikariDataSource source = new HikariDataSource();
        source.setJdbcUrl(ConnectionUtil.MysqlConnectionConstant.URL);
        source.setUsername(ConnectionUtil.MysqlConnectionConstant.USER);
        source.setPassword(ConnectionUtil.MysqlConnectionConstant.PASSWORD);
        source.setMaximumPoolSize(5);
        Connection conn1 = source.getConnection();
        Connection conn2 = source.getConnection();

        Thread.sleep(5000);


    }

}
