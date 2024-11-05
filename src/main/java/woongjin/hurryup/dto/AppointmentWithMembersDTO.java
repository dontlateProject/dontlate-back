package woongjin.hurryup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentWithMembersDTO {
    private Long appointmentId;
    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private boolean appointmentStatus;
    private String penalty;
    private String appointmentCreatedNickname;
    private List<AppointmentParticipantDTO> participants;
}
