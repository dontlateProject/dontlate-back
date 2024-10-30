package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String meetingName;
    private String meetingInfo;
    private long meetingCreatedId;
    private LocalDateTime createdAt;

//    @OneToMany
//    private List<GroupMembership> groupMemberships;

}
