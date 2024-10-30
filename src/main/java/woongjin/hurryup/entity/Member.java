package woongjin.hurryup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private String memberId;

    @Column(unique = true)
    private String nickname;

    private String password;

    private LocalDateTime createdAt;
    //    private String email;
//    private String phone

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GroupMembership> groupMembership;
}
