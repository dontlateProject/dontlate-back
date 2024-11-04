package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByMemberId(String memberId);
    Optional<Member> findByNickname(String nickname);
}
