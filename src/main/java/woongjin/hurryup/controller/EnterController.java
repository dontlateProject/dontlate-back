package woongjin.hurryup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterController {

    @GetMapping("/api/enter")
    public String enter() {
        return "Enter Page";
    }
}
