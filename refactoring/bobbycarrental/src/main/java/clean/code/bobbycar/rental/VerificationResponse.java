package clean.code.bobbycar.rental;

import java.util.List;

public class VerificationResponse {

    private List<VerifiedDriver> verifiedDrivers;

    public VerificationResponse() {
    }

    public VerificationResponse(List<VerifiedDriver> verifiedDrivers) {
        this.verifiedDrivers = verifiedDrivers;
    }

    public List<VerifiedDriver> getVerifiedDrivers() {
        return verifiedDrivers;
    }

    public void setVerifiedDrivers(List<VerifiedDriver> verifiedDrivers) {
        this.verifiedDrivers = verifiedDrivers;
    }
}
