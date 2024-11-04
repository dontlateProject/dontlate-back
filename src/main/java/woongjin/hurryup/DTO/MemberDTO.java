package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class MemberDTO {
    private String memberId;
    private String nickname;
    private String phone;
    private LocalDateTime createdAt;
    private String password;
}
