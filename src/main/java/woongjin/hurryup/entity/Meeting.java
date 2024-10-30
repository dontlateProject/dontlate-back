package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String meetingName;
    private String meetingInfo;
    private long meetingCreatedId;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

//    @OneToMany
//    private List<GroupMembership> groupMemberships;

}
