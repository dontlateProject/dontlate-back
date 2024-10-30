package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import woongjin.hurryup.entity.Appointment;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = """
    SELECT * From appointment WHERE appointment_id IN ( 
    SELECT appointment_id FROM group_membership 
    WHERE meeting_id = :meetingId
    GROUP BY appointment_id 
)
""", nativeQuery = true)
    List<Appointment> findAppointmentByMeetingId(@Param("meetingId") Long meetingId);
}
