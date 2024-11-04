package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import woongjin.hurryup.entity.GroupMembership;

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
    private Long appointmentId;

    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private Boolean appointmentStatus;
    private String appointmentCreatedId;
    private String penalty;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "appointment")
    private List<GroupMembership> groupMemberships; // 이 관계가 중요합니다.

    // 직접 GroupMembership에 대한 ManyToOne 관계가 필요 없다면 아래 필드는 제거
}
