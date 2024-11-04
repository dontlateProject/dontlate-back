package woongjin.hurryup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import woongjin.hurryup.entity.GroupMembership;
import woongjin.hurryup.repository.GroupMembershipRepository;

import java.util.List;

@Service
public class GroupMembershipService {

    @Autowired
    private GroupMembershipRepository groupMembershipRepository;

    // 그룹 멤버십 추가
    public GroupMembership addMembership(GroupMembership groupMembership) {
        return groupMembershipRepository.save(groupMembership);
    }

    // 특정 회원의 모든 그룹 멤버십 조회
    public List<GroupMembership> getMembershipsByMemberId(String memberId) {
        return groupMembershipRepository.findByMemberId(memberId);
    }

    // 특정 미팅의 모든 그룹 멤버십 조회
    public List<GroupMembership> getMembershipsByMeetingId(Long meetingId) {
        return groupMembershipRepository.findByMeetingId(meetingId);
    }

    // 그룹 멤버십 삭제
    public void removeMembership(Long membershipId) {
        groupMembershipRepository.deleteById(membershipId);
    }
}
