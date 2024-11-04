package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GroupMemberShipDTO {
    private Long membershipId;
    private String memberId;
    private Long appointmentId;
    private Long meetingId;
    private LocalDateTime arriveTime;
    private Boolean isLate;
    private String joinedGroup;
}
