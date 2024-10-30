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
    private Long appointmentId;

    private String appointmentName;
    private LocalDateTime appointmentTime;
    private String location;
    private String appointmentStatus;
    private long appointmentCreatedId;
    private String penalty;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
    private List<GroupMembership> groupMemberships;

}
