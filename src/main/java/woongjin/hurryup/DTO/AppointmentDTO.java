package woongjin.hurryup.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long appointmentId;
    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private String appointmentStatus;
    private long appointmentCreatedId;
    private String penalty;
}
