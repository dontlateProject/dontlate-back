package woongjin.hurryup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.ModifyRequestDTO; // 정보 수정 DTO
import woongjin.hurryup.service.MemberService;

@RestController
@RequestMapping("/api")
public class ModifyController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody ModifyRequestDTO modifyRequest) {
        boolean success = memberService.modify(modifyRequest);
        return success ? ResponseEntity.ok("정보 수정 성공") : ResponseEntity.badRequest().body("정보 수정 실패");
    }
}
