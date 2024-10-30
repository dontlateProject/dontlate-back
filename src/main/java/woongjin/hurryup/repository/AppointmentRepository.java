package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
