package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByGroupMembershipMeetingId(Long meetingId);

    List<Appointment> findByGroupMembershipMemberIdAndGroupMembershipMeetingId(String memberId, Long meetingId);
}
