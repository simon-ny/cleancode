package clean.code.dependency.verification;

import clean.code.dependency.verification.Verification;

import java.util.List;

public class VerificationResponse {
    private List<Verification> verifiedDrivers;

    public VerificationResponse(List<Verification> verifiedDrivers) {
        this.verifiedDrivers = verifiedDrivers;
    }

    public List<Verification> getVerifiedDrivers() {
        return verifiedDrivers;
    }

    public void setVerifiedDrivers(List<Verification> verifiedDrivers) {
        this.verifiedDrivers = verifiedDrivers;
    }
}
