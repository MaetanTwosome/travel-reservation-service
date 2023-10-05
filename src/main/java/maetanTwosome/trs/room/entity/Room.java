package maetanTwosome.trs.room.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maetanTwosome.trs.reservation.entity.Reservation;

import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String dayUsePrice;

    @Column(nullable = false)
    private String stayUsePrice;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String content;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Builder
    public Room(Long id, String name, String type, String dayUsePrice, String stayUsePrice, String status, String content) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dayUsePrice = dayUsePrice;
        this.stayUsePrice = stayUsePrice;
        this.status = status;
        this.content = content;
    }
}
