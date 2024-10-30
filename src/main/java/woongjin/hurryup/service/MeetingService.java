package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.DTO.MeetingWithMembersDTO;
import woongjin.hurryup.entity.Meeting;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.repository.AppointmentRepository;
import woongjin.hurryup.repository.MeetingRepository;
import woongjin.hurryup.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MemberRepository memberRepository;
    private final MeetingRepository meetingRepository;
    private final AppointmentRepository appointmentRepository;

    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public MeetingWithMembersDTO getMeetingWithMembers(Long meetingId) {

        Meeting meeting = meetingRepository.findById(meetingId)
                .orElseThrow(() -> new IllegalArgumentException("그룹이 없습니다."));

        List<Member> members = memberRepository.findMemberByMeetingId(meetingId);

        return new MeetingWithMembersDTO(meeting.getMeetingId(), meeting.getMeetingName(),  meeting.getMeetingInfo(), members);
    }


}
