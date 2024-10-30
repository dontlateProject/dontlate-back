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
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String meetingName;
    private String meetingInfo;
    private long meetingCreatedId;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    private List<GroupMembership> groupMemberships;

}
