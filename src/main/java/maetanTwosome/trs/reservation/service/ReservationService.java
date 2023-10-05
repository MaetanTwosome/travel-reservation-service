package maetanTwosome.trs.reservation.service;

import lombok.RequiredArgsConstructor;
import maetanTwosome.trs.reservation.dto.ReservationRequest;
import maetanTwosome.trs.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Long saveReservation(ReservationRequest reservationRequest) {

        return reservationRepository.save(reservationRequest.toEntity()).getId();
    }

}
