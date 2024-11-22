package org.fosho.jdbc.repository;

import org.fosho.jdbc.domain.Member;
import org.fosho.jdbc.util.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberRepository implements MemberRepository {

    private static final String CREATE_QUERY = "INSERT INTO member (username, password) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE member SET username = ?, password = ? WHERE member_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM member WHERE member_id = ?";
    private static final String GET_QUERY = "SELECT * FROM member WHERE member_id = ?";
    private static final String GET_ALL_QUERY = "SELECT * FROM member";

    @Override
    public void create(Member member) {
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(CREATE_QUERY)) {
            pstmt.setString(1, member.getUsername());
            pstmt.setString(2, member.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating member", e);
        }
    }

    @Override
    public void update(Member member) {
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY)) {
            pstmt.setString(1, member.getUsername());
            pstmt.setString(2, member.getPassword());
            pstmt.setInt(3, member.getMemberId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating member", e);
        }
    }

    @Override
    public void delete(Integer memberId) {
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_QUERY)) {
            pstmt.setInt(1, memberId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting member", e);
        }
    }

    @Override
    public Member get(Integer memberId) {
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(GET_QUERY)) {
            pstmt.setInt(1, memberId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                            rs.getInt("member_id"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching member", e);
        }
    }

    @Override
    public List<Member> getAll() {
        List<Member> members = new ArrayList<>();
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(GET_ALL_QUERY);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                members.add(new Member(
                        rs.getInt("member_id"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all members", e);
        }
        return members;
    }
}
