package clean.code.dependency.web;

import clean.code.dependency.reservation.ReservationRequest;
import clean.code.dependency.reservation.ReservationService;
import clean.code.dependency.reservation.ReservationResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ReservationApi {

    private final ReservationService reservationService;

    public ReservationApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservation")
    public ReservationResponse makeReservation(
            @RequestBody ReservationRequest reservationRequest) {
        return reservationService.checkAvailability(reservationRequest);
    }
}
