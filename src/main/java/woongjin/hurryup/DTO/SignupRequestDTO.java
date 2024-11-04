package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRequestDTO {
    private String memberId; // 회원 ID
    private String password; // 비밀번호
    private String nickname; // 닉네임
    private String phone; // 전화번호
}
