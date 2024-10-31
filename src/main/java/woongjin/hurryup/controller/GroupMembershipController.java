package woongjin.hurryup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.entity.GroupMembership;
import woongjin.hurryup.exception.member.MemberNotFoundException;
import woongjin.hurryup.service.GroupMembershipService;

@RestController
@RequestMapping("/api/membership")
@RequiredArgsConstructor
public class GroupMembershipController {

    private final GroupMembershipService groupMembershipService;

    // 그룹내 멤버 추가
    @PostMapping("/member")
    public ResponseEntity<MemberDTO> createMemberInMeeting(@RequestBody GroupMembership groupMembership) {

            MemberDTO memberInMeeting = groupMembershipService.createMemberInMeeting(groupMembership);
            return  ResponseEntity.ok(memberInMeeting);
    }
}
