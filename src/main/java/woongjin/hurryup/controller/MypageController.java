package woongjin.hurryup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.MemberDTO; // 회원 정보 DTO
import woongjin.hurryup.service.MemberService;
import woongjin.hurryup.mapper.MemberMapper; // Mapper

@RestController
@RequestMapping("/api")
public class MypageController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/mypage")
    public MemberDTO getUserInfo(@RequestParam String id) {
        return memberService.getMemberInfo(id)
                .map(MemberMapper.INSTANCE::memberToMemberDTO) // Member 엔티티를 DTO로 변환
                .orElse(null); // 사용자가 없을 경우 null 반환
    }
}
