package woongjin.hurryup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import woongjin.hurryup.dto.AppointmentWithMembersDTO;
import woongjin.hurryup.dto.AppointmentParticipantDTO;
import woongjin.hurryup.entity.Appointment;
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.repository.AppointmentRepository;
import woongjin.hurryup.repository.GroupMembershipRepository;
import woongjin.hurryup.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final MemberRepository memberRepository;
    private final GroupMembershipRepository groupMembershipRepository;

    // 약속 생성
    public Appointment create(Appointment appointment) {
        appointment.setAppointmentStatus(false);
        appointment.setCreatedAt(LocalDateTime.now());
        return this.appointmentRepository.save(appointment);
    }

    // 약속 상세 데이터 조회
    public AppointmentWithMembersDTO getAppointment(long appointmentId) {
        Appointment appt = this.appointmentRepository.findById(appointmentId).orElseThrow(() -> new IllegalArgumentException("not found appointment by id"));
        Member member = this.memberRepository.findById(appt.getAppointmentCreatedId()).orElseThrow(() -> new IllegalArgumentException("not found appointmentCreator"));
        String nickname = member.getNickname();
        List<AppointmentParticipantDTO> participants = getParticipants(appointmentId);

        return new AppointmentWithMembersDTO(appt.getAppointmentId(), appt.getAppointmentName(), appt.getAppointmentTime(), appt.getLocation(), appt.isAppointmentStatus(), appt.getPenalty(), nickname, participants);
    }

    // 약속 참성자 조회
    public List<AppointmentParticipantDTO> getParticipants(long appointmentId) {
        return groupMembershipRepository.findParticipantsByAppointmentId(appointmentId);
    }

}
