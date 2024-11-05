package woongjin.hurryup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentParticipantDTO {
    private String memberId;
    private String nickname;
    private LocalDateTime arriveTime;
    private boolean isLate;
}
