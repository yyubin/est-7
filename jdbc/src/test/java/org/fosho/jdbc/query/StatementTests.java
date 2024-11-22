package org.fosho.jdbc.query;

import lombok.extern.slf4j.Slf4j;
import org.fosho.jdbc.domain.Member;
import org.fosho.jdbc.util.ConnectionUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StatementTests {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    @BeforeEach
    void setUp() {
        conn = ConnectionUtil.getConnection();
    }

    @AfterEach
    void tearDown() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }

    }

    @Test
    @DisplayName("Jdbc INSERT into Member")
    void jdbc_insert_test() throws Exception {
        // 회원이 회원정보를 입력해서 받았다
        Member admin = getMember("admin", "admin");
        Member user = getMember("user", "user");

        String sql1 = genInsertMemberQuery(admin);
        String sql2 = genInsertMemberQuery(user);

        stmt = conn.createStatement();
        int result1 = stmt.executeUpdate(sql1);
        log.info("result1 = {}", result1);
        int result2 = stmt.executeUpdate(sql2);
        log.info("result2 = {}", result2);
    }

    private String genInsertMemberQuery(Member member) {
        return "INSERT INTO member (username, password) VALUES ('%s', '%s')"
                .formatted(member.getUsername(), member.getPassword());
    }

    private Member getMember(String username, String password) {
        return new Member(0, username, password);
    }

    @Test
    @DisplayName("jdbc select test(login)")
    void jdbc_login_test() throws Exception {
        Member user = getMember("user", "user");
        String sql = genSelect(user);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        Member findMember = new Member();
        if (rs.next()) {
            findMember.setMemberId(rs.getInt("member_id"));
            findMember.setUsername(rs.getString("username"));
            findMember.setPassword(rs.getString("password"));
        }

        log.info("findMember.getUsername() = {}", findMember.getUsername());
        log.info("findMember.getPassword() = {}", findMember.getPassword());
        assertThat(findMember).isNotNull();
        assertThat(findMember.getUsername()).isEqualTo("user");
        assertThat(findMember.getPassword()).isEqualTo("user");
    }

    private static String genSelect(Member member) {
        return "SELECT m.member_id, m.username, m.password FROM member as m where m.username = '%s' and m.password = '%s'".formatted(member.getUsername(), member.getPassword());
    }

    @Test
    @DisplayName("jdbc prepared statement")
    void prepared_statement_test() throws Exception {
        Member wtf = getMember("admin", "' or '' = ''");
        String sql = "SELECT m.username, m.password FROM member as m where m.username = ? and m.password = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, wtf.getPassword());
        pstmt.setString(2, wtf.getPassword());

        rs = pstmt.executeQuery();
        Member findMember = new Member();
        if (rs.next()) {
            findMember.setMemberId(rs.getInt("member_id"));
            findMember.setUsername(rs.getString("username"));
            findMember.setPassword(rs.getString("password"));
        }
        log.info("findMember.getUsername() = {}", findMember.getUsername());

    }


}
