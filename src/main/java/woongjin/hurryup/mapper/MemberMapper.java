package woongjin.hurryup.mapper;

import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMapper {

    public static MemberDTO convertToMemberDto(Member member) {
        return MemberDTO.builder()
                .memberId(member.getMemberId())
                .nickname(member.getNickname())
                .build();
    }

    public static List<MemberDTO> convertToMemberDtoList(List<Member> members) {
        return members.stream()
                .map(MemberMapper::convertToMemberDto)
                .collect(Collectors.toList());
    }

}
