package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.GroupMembership;

import java.util.List;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {
    List<GroupMembership> findByMemberId(String memberId);
    List<GroupMembership> findByMeetingId(Long meetingId);
}
