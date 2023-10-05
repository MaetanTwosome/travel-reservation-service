package maetanTwosome.trs.reservation.dto;

import lombok.*;
import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.reservation.entity.Reservation;
import maetanTwosome.trs.room.entity.Room;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReservationRequest {

    private Date startDate;
    private Date endDate;
    private String direction;
    private String request;
    private Room room;
    private int guestNumber;

    public Reservation toEntity() {
        return Reservation.builder()
                .startDate(startDate)
                .endDate(endDate)
                .guestNumber(guestNumber)
                .direction(direction)
                .request(request)
                .room(room)
                .build();
    }
}
