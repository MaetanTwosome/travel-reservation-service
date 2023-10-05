package maetanTwosome.trs.member.entity;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maetanTwosome.trs.member.dto.MemberUpdateRequestDto;
import maetanTwosome.trs.reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static maetanTwosome.trs.member.entity.Provider.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Provider provider;

    private String providerId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joinDate;

    @OneToMany
    @JoinColumn(name = "reservation_id")
    private final List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Member(Long id, String email, String password, String phoneNumber, String nickname, String name, Role role, Provider provider, String providerId, Date lastLoginDate, Date joinDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.name = name;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.lastLoginDate = lastLoginDate;
        this.joinDate = joinDate;
    }

    // TODO: 어떤 값 수정 필요한 지 한번 더 확인
    public void update(MemberUpdateRequestDto dto) {
        if (isEmailAccount()) {
            this.password = dto.getPassword();
        }
        this.nickname = dto.getNickname();
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
    }

    private boolean isEmailAccount() {
        return NONE.equals(this.provider);
    }
}
