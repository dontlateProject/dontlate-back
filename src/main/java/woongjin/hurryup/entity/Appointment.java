package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId; // 약속 ID

    private String appointmentName; // 약속 이름
    private LocalDateTime appointmentTime; // 약속 날짜, 시간
    private String location; // 약속 장소
    private String appointmentStatus; // 약속 상태 (예정, 완료)
    private long appointmentCreatedId; // 약속 생성자 (memberId)
    private String penalty; // 벌칙 내용
    private LocalDateTime createdAt; // 약속 생성일

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
    private List<GroupMembership> groupMemberships;

}
