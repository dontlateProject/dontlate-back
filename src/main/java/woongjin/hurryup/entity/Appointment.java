package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private String appointmentStatus;
    private long appointmentCreatedId;
    private String penalty;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

//    @OneToMany
//    private List<GroupMembership> groupMemberships;

}
