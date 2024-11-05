package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import woongjin.hurryup.dto.AppointmentParticipantDTO;
import woongjin.hurryup.entity.GroupMembership;

import java.util.List;

@Repository
public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Long> {

    @Query("SELECT new woongjin.hurryup.dto.AppointmentParticipantDTO(gm.member.memberId, m.nickname, gm.arriveTime, gm.isLate) " +
            "FROM GroupMembership gm JOIN gm.member m " +
            "WHERE gm.appointment.appointmentId = :appointmentId")
    List<AppointmentParticipantDTO> findParticipantsByAppointmentId(@Param("appointmentId") Long appointmentId);

}
