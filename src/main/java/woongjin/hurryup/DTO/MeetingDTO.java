package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MeetingDTO {
    private Long meetingId;
    private String meetingName;
    private LocalDateTime meetingCreateDate;
    private String meetingInfo;
}
