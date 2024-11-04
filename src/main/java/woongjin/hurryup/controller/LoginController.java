package woongjin.hurryup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.LoginRequestDTO;
import woongjin.hurryup.service.MemberService;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {
        boolean success = memberService.login(loginRequest);
        return success ? ResponseEntity.ok("로그인 성공") : ResponseEntity.status(401).body("로그인 실패");
    }
}
