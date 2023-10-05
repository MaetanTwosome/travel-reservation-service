package maetanTwosome.trs.reservation.repository;

import maetanTwosome.trs.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
