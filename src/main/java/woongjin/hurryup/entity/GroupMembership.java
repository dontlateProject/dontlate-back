package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMembership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long membership_id;
    private LocalDateTime arriveTime;
    private boolean isLate;
    private LocalDateTime joinedGroup;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "meetingId")
    private Meeting meetingId;


}
