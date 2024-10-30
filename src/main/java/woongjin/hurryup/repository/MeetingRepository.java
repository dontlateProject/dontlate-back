package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import woongjin.hurryup.entity.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}
