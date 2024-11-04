package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ModifyRequestDTO {
    private String memberId; // 수정할 회원 ID
    private String newNickname; // 새 닉네임
    private String newPassword; // 새 비밀번호
    private String newPhone; // 새 전화번호
    private LocalDateTime createdAt;
}
