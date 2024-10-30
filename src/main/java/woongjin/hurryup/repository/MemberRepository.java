package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
