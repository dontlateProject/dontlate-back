package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import woongjin.hurryup.entity.Member;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MeetingWithMembersDTO {
    private Long meetingId;
    private String meetingName;
    private String meetingInfo;
    private List<Member> members;
}
