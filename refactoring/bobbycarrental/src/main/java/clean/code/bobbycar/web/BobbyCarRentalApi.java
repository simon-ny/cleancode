package clean.code.bobbycar.web;

import clean.code.bobbycar.rental.RentalService;
import clean.code.bobbycar.rental.VerificationResponse;
import clean.code.bobbycar.web.dto.RentalOptions;
import clean.code.bobbycar.web.dto.RentalResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BobbyCarRentalApi {

    private final RentalService rentalService;

    public BobbyCarRentalApi(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rent")
    public ResponseEntity<RentalResult> rentBobbyCar(
            @RequestBody RentalOptions rentalOptions) {
        return ResponseEntity.ok(rentalService.rent(rentalOptions));
    }

    @GetMapping("/ping")
    public String ping() {
        return "UP";
    }
}
