package woongjin.hurryup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.SignupRequestDTO;
import woongjin.hurryup.service.MemberService;

@RestController
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDTO signupRequest) {
        boolean success = memberService.signup(signupRequest);
        return success ? ResponseEntity.ok("회원가입 성공") : ResponseEntity.badRequest().body("회원가입 실패");
    }

    @GetMapping("/check-id/{id}")
    public ResponseEntity<Boolean> checkDuplicateId(@PathVariable String id) {
        boolean isDuplicate = memberService.checkDuplicateId(id);
        return ResponseEntity.ok(isDuplicate);
    }

    @GetMapping("/check-nickname/{nickname}")
    public ResponseEntity<Boolean> checkDuplicateNickname(@PathVariable String nickname) {
        boolean isDuplicate = memberService.checkDuplicateNickname(nickname);
        return ResponseEntity.ok(isDuplicate);
    }
}
