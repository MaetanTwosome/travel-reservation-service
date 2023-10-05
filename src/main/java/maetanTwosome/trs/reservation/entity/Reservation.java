package maetanTwosome.trs.reservation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.room.entity.Room;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private int guestNumber;

    @Column(nullable = false)
    private String status;

    private String request;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date modificationDate;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @OneToOne(mappedBy = "reservation")
    private Room room;

    @Builder
    public Reservation(Long id, Date reservationDate, int guestNumber, String status, String request, Date modificationDate, String direction, Date startDate, Date endDate, Room room) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.guestNumber = guestNumber;
        this.status = status;
        this.request = request;
        this.modificationDate = modificationDate;
        this.direction = direction;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }
}
