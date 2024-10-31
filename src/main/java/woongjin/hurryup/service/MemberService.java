package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.DTO.MemberLateCountDTO;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.exception.member.MemberNotFoundException;
import woongjin.hurryup.mapper.MemberMapper;
import woongjin.hurryup.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMemberByMeetingId(Long id) {
        return memberRepository.findMemberByMeetingId(id);
    }

    public MemberDTO getMemberById(String id) {

        return memberRepository.findById(id)
                        .map(MemberMapper::convertToMemberDto)
                .orElseThrow(() -> new MemberNotFoundException("member id : " + id + " not found"));
    }
}
