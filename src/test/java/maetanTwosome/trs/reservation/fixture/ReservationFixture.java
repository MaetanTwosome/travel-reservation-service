package maetanTwosome.trs.reservation.fixture;

import maetanTwosome.trs.member.entity.Member;
import maetanTwosome.trs.member.entity.Provider;
import maetanTwosome.trs.member.entity.Role;
import maetanTwosome.trs.member.fixture.MemberFixture;
import maetanTwosome.trs.reservation.entity.Reservation;
import maetanTwosome.trs.room.entity.Room;
import maetanTwosome.trs.room.fixture.RoomFixture;

public class ReservationFixture {

    public static Reservation createReservation() {
        return Reservation.builder()
                .id(1L)
                .guestNumber(2)
                .status("1")
                .request("금연실 부탁드립니다.")
                .direction("도보")
                .room(RoomFixture.createRoom())
                .build();
    };
}
