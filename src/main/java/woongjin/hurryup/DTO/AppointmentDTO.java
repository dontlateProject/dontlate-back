package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppointmentDTO {
    private Long appointmentId;
    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private String penalty;
}
