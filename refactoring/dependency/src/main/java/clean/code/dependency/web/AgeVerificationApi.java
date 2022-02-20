package clean.code.dependency.web;

import clean.code.dependency.verification.AgeVerificationService;
import clean.code.dependency.verification.VerificationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AgeVerificationApi {

    private final AgeVerificationService ageVerificationService;

    public AgeVerificationApi(AgeVerificationService ageVerificationService) {
        this.ageVerificationService = ageVerificationService;
    }

    @GetMapping("/verify/")
    public VerificationResponse verifyDriverAge(
            @RequestParam List<Integer> age) {
        return ageVerificationService.verify(age);
    }

    @GetMapping("/ping")
    public String ping() {
        return "UP";
    }
}
