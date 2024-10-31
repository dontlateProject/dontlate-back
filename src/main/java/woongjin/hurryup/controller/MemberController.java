package woongjin.hurryup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.service.MemberService;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable String id) {

        MemberDTO memberById = memberService.getMemberById(id);
        return ResponseEntity.ok(memberById);
    }
}
