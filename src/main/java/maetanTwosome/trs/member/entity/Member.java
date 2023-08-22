package maetanTwosome.trs.member.entity;

import jakarta.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
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
    private Date joinDate;

    @Builder
    public Member(Long id, String email, String password, String phoneNumber, String nickname,
                  String name, String role, char oauthType, Date lastLoginDate, Date joinDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.name = name;
        this.role = role;
        this.oauthType = oauthType;
        this.lastLoginDate = lastLoginDate;
        this.joinDate = joinDate;
    }

    public void update(String updateName) {
        this.name = updateName; // test 용도
    }
}
