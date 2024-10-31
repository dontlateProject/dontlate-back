package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.DTO.*;
import woongjin.hurryup.entity.Meeting;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.exception.meeting.MeetingNotFoundException;
import woongjin.hurryup.mapper.MemberMapper;
import woongjin.hurryup.repository.AppointmentRepository;
import woongjin.hurryup.repository.MeetingRepository;
import woongjin.hurryup.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MemberRepository memberRepository;
    private final MeetingRepository meetingRepository;
    private final AppointmentRepository appointmentRepository;

    // 그룹 생성
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    // 그룹 정보, 멤버 랭킹, 멤버 조회
    public MeetingWithMembersDTO getMeetingWithMembers(Long meetingId) {

        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new MeetingNotFoundException("그룹이 없습니다."));
        List<MemberLateCountDTO> memberByMeetingIdOrderByLate = convertToDto(memberRepository.findMemberByMeetingIdOrderByLate(meetingId));

        List<MemberDTO> members = MemberMapper.convertToMemberDtoList(memberRepository.findMemberByMeetingId(meetingId));

        return new MeetingWithMembersDTO(meeting.getMeetingId(), meeting.getMeetingName(),  meeting.getMeetingInfo(), memberByMeetingIdOrderByLate, members);
    }

    // 멤버 랭킹, 멤버 조회
    public MemberAndRankDTO getMembersAndRank(Long meetingId) {

        List<MemberLateCountDTO> memberByMeetingIdOrderByLate = convertToDto(memberRepository.findMemberByMeetingIdOrderByLate(meetingId));
        List<MemberDTO> members = MemberMapper.convertToMemberDtoList(memberRepository.findMemberByMeetingId(meetingId));

        return new MemberAndRankDTO(memberByMeetingIdOrderByLate,members);
    }

    public List<AppointmentDTO> getAppointmentByMeetingId(Long meetingId) {
        return appointmentRepository.findAppointmentByMeetingId(meetingId).stream()
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
    }

    // MemberLateCountDTO 변환 메서드
    private List<MemberLateCountDTO> convertToDto(List<Object[]> results) {

        return results.stream()
                .map(result -> MemberLateCountDTO.builder()
                        .memberId((String) result[0])
                        .nickname((String) result[1])
                        .appointmentId(((Number) result[2]).longValue())
                        .lateCount(((Number) result[3]).intValue())
                        .lateTime(((Number) result[4]).intValue())
                        .build())
                .collect(Collectors.toList());

//        List<MemberLateCountDTO> dtos = new ArrayList<>();
//        for (Object[] result : results) {
//            String memberId = (String) result[0];
//            String nickname = (String) result[1];
//            Long appointmentId = ((Number) result[2]).longValue();
//            int lateCount = ((Number)result[3]).intValue();
//            int lateTime = ((Number)result[4]).intValue();
//
//            dtos.add(MemberLateCountDTO.builder()
//                            .memberId(memberId)
//                            .nickname(nickname)
//                            .appointmentId(appointmentId)
//                            .lateCount(lateCount)
//                            .lateTime(lateTime)
//                    .build());
//        }
//        return dtos;
    }

}
