package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMemberByMeetingId(Long id) {
        return memberRepository.findMemberByMeetingId(id);
    }

}
