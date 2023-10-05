package maetanTwosome.trs.reservation.repository;

import maetanTwosome.trs.reservation.entity.Reservation;
import maetanTwosome.trs.reservation.fixture.ReservationFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @DisplayName("예약을 한다.")
    @Test
    void create() {
        Reservation reservation = ReservationFixture.createReservation();

        Reservation bookedReservation = reservationRepository.save(reservation);

        Assertions.assertThat(bookedReservation.getId()).isEqualTo(reservation.getId());
    }

}