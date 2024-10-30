package woongjin.hurryup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import woongjin.hurryup.DTO.AppointmentDTO;
import woongjin.hurryup.DTO.MeetingWithMembersDTO;
import woongjin.hurryup.DTO.MemberDTO;
import woongjin.hurryup.entity.Appointment;
import woongjin.hurryup.entity.Meeting;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.repository.MeetingRepository;
import woongjin.hurryup.service.AppointmentService;
import woongjin.hurryup.service.MeetingService;
import woongjin.hurryup.service.MemberService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/meeting")
@RequiredArgsConstructor
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    private final MeetingService meetingService;
    private final MemberService memberService;
    private final AppointmentService appointmentService;

    // Create 미팅 생성
    @PostMapping
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        return new ResponseEntity<>( meetingService.createMeeting(meeting), HttpStatus.CREATED);
    }

    // 미팅 정보 접속시 member와 그룹 정보 조회
    @GetMapping("/{id}")
    public  ResponseEntity<MeetingWithMembersDTO> getMeetingById(@PathVariable Long id) {
//        return meetingRepository.findById(id)
//                .map(meeting -> new ResponseEntity<>(meeting, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        try {
            MeetingWithMembersDTO dto = meetingService.getMeetingWithMembers(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 탭 누를시 그룹 멤버 조회
    @GetMapping("/{id}/member")
    public  ResponseEntity<List<MemberDTO>> getMemberByMeetingId(@PathVariable Long id) {
        List<Member> memberByMeetingId = memberService.getMemberByMeetingId(id);
        List<MemberDTO> memberDTOS = memberByMeetingId.stream()
                .map(member -> new MemberDTO(member.getMemberId(), member.getNickname()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(memberDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}/appointment")
    public  ResponseEntity<List<AppointmentDTO>> getAppointmentByMeetingId(@PathVariable Long id) {
        List<Appointment> appointmentByMeetingId = appointmentService.getAppointmentByMeetingId(id);
        List<AppointmentDTO> appointmentDTOS = appointmentByMeetingId.stream()
                .map(appointment -> AppointmentDTO.builder()
                        .appointmentId(appointment.getAppointmentId())
                        .appointmentName(appointment.getAppointmentName())
                        .appointmentTime(appointment.getAppointmentTime())
                        .location(appointment.getLocation())
                        .appointmentStatus(appointment.getAppointmentStatus())
                        .appointmentCreatedId(appointment.getAppointmentCreatedId())
                        .penalty(appointment.getPenalty())
                        .build())
                .collect(Collectors.toList());

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.OK);
    }
}

