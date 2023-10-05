package maetanTwosome.trs.reservation.controller;

import lombok.RequiredArgsConstructor;

import maetanTwosome.trs.reservation.dto.ReservationRequest;
import maetanTwosome.trs.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/reservation")
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/book")
    public ResponseEntity<String> book(@RequestBody ReservationRequest reservationRequest) {

        reservationService.saveReservation(reservationRequest);

        return ResponseEntity.ok("POST request successful");
    }
}
