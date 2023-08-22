package maetanTwosome.trs.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String phoneNumber;
    private String nickname;
    private String name;
    private String role;
    private char oauthType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date JoinDate;

}
