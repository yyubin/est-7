package org.fosho.jdbc.repository;
import org.fosho.jdbc.domain.Member;

import java.util.List;

public interface MemberRepository {
    void create(Member member);
    void update(Member member);
    void delete(Integer memberId);
    Member get(Integer memberId);
    List<Member> getAll();
}
