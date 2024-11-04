package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDTO {
    private String memberId; // 아이디
    private String password; // 비밀번호
}
