package woongjin.hurryup.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import woongjin.hurryup.entity.Member;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MemberAndRankDTO {
    private List<MemberLateCountDTO> memberLateCountDTOS;
    private List<MemberDTO> members;
}
