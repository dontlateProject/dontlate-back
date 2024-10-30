package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.GroupMembership;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {
}
