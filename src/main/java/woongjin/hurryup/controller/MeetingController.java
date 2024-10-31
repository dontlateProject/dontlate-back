package woongjin.hurryup.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.*;

import woongjin.hurryup.entity.Meeting;



import woongjin.hurryup.service.MeetingService;


import java.util.List;


@RestController
@RequestMapping("/api/meeting")
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    // 미팅 생성
    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        return ResponseEntity.status(HttpStatus.CREATED).body( meetingService.createMeeting(meeting));
    }

    // 미팅 정보 조회 (member와 랭킹, 그룹 정보 포함)
    @GetMapping("/{id}")
    public  ResponseEntity<MeetingWithMembersDTO> getMeetingById(@PathVariable Long id) {
            MeetingWithMembersDTO dto = meetingService.getMeetingWithMembers(id);
            return ResponseEntity.ok(dto);
    }

    // 그룹 멤버 조회
    @GetMapping("/{id}/member")
    public  ResponseEntity<MemberAndRankDTO> getMemberByMeetingId(@PathVariable Long id) {
        MemberAndRankDTO dto = meetingService.getMembersAndRank(id);
        return ResponseEntity.ok(dto);
    }

    // 그룹 약속 조회
    @GetMapping("/{id}/appointment")
    public  ResponseEntity<List<AppointmentDTO>> getAppointmentByMeetingId(@PathVariable Long id) {
        return ResponseEntity.ok(meetingService.getAppointmentByMeetingId(id));
    }
}

