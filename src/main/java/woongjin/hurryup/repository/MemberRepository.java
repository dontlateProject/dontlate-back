package woongjin.hurryup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import woongjin.hurryup.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query(value = """
    SELECT * From Member WHERE MEMBER_ID IN ( 
    SELECT MEMBER_ID FROM group_membership 
    WHERE meeting_id = :meetingId
    GROUP BY MEMBER_ID 
)
""", nativeQuery = true)
    List<Member> findMemberByMeetingId(@Param("meetingId") Long meetingId);
}
