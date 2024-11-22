package org.fosho.jdbc.repository;

import org.fosho.jdbc.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JdbcMemberRepositoryTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private JdbcMemberRepository jdbcMemberRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("유저 생성 테스트")
    void testCreateMember() {
        // given
        Member member = new Member(1, "testuser", "testpassword");

        // when
        jdbcMemberRepository.create(member);

        // then
        verify(memberRepository, times(1)).create(member);
    }

    @Test
    @DisplayName("유저 수정 테스트")
    void testUpdateMember() {
        // given
        Member member = new Member(1, "updateuser", "updatepassword");

        // when
        jdbcMemberRepository.update(member);

        // then
        verify(memberRepository, times(1)).update(member);
    }

    @Test
    @DisplayName("유저 삭제 테스트")
    void testDeleteMember() {
        // given
        Member member = new Member(1, "deleteuser", "deletepassword");

        // when
        jdbcMemberRepository.delete(1);

        // then
        verify(memberRepository, times(1)).delete(1);
    }

    @Test
    @DisplayName("유저 조회 테스트")
    void testGetMember() {
        // given
        Member member = new Member(1, "getuser", "getpassword");
        memberRepository.create(member);

        // when
        Member fetchedMember = memberRepository.get(member.getMemberId());

        // then
        assertNotNull(fetchedMember);
        assertEquals("getuser", fetchedMember.getUsername());
        assertEquals("getpassword", fetchedMember.getPassword());
    }

    @Test
    @DisplayName("유저 전체 조회 테스트")
    void testGetAllMembers() {
        // given
        Member member1 = new Member(1, "user1", "password1");
        Member member2 = new Member(2, "user2", "password2");

        // when
        when(memberRepository.getAll()).thenReturn(List.of(member1, member2));  // getAll 메서드가 호출될 때 두 개의 멤버를 반환하도록 설정
        List<Member> members = jdbcMemberRepository.getAll();

        // then
        assertNotNull(members);
        assertTrue(members.size() >= 2);
    }
}
