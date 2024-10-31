package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.entity.GroupMembership;
import woongjin.hurryup.exception.member.MemberNotFoundException;
import woongjin.hurryup.mapper.MemberMapper;
import woongjin.hurryup.repository.GroupMembershipRepository;
import woongjin.hurryup.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class GroupMembershipService {

    private final GroupMembershipRepository groupMembershipRepository;
    private final MemberRepository memberRepository;


    public MemberDTO createMemberInMeeting(GroupMembership groupMembership) {

        GroupMembership saved = groupMembershipRepository.save(groupMembership);

        return memberRepository.findById(saved.getMember().getMemberId())
                .map(MemberMapper::convertToMemberDto)
                .orElseThrow(() -> new MemberNotFoundException("member Id not found : " + saved.getMember().getMemberId()));
    }

}
