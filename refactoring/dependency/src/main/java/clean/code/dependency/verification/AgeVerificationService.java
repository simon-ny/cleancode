package clean.code.dependency.verification;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgeVerificationService {
    public VerificationResponse verify(List<Integer> age) {
        return new VerificationResponse(
                age
                .stream()
                .map(Verification::new)
                .collect(Collectors.toList()));
    }
}
