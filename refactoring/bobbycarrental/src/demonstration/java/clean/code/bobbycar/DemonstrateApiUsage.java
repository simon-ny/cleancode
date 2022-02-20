package clean.code.bobbycar;

import clean.code.bobbycar.web.dto.Driver;
import clean.code.bobbycar.web.dto.RentalOptions;
import clean.code.bobbycar.web.dto.RentalResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemonstrateApiUsage {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void makeApiCallWithMultipleDriversOfDifferentAge() {
        // given
        RentalOptions rentalOptions = createRentalOptionsDifferentAge();
        List<String> requestDriverNames = rentalOptions.getDrivers().stream().map(Driver::getName).collect(Collectors.toList());

        // when
        RentalResult response = restTemplate
                .postForObject("http://localhost:" + port + "/api/v1/rent" , rentalOptions, RentalResult.class);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getDrivers().size()).isEqualTo(rentalOptions.getDrivers().size());
        List<String> responseDriverNames = response.getDrivers().stream().map(Driver::getName).collect(Collectors.toList());
        assertThat(responseDriverNames).containsExactlyElementsOf(requestDriverNames);
    }

    @Test
    public void makeApiCallWithMultipleDriversOfSameAge() {
        // given
        RentalOptions rentalOptions = createRentalOptionsSameAge();
        List<String> requestDriverNames = rentalOptions.getDrivers().stream().map(Driver::getName).collect(Collectors.toList());

        // when
        RentalResult response = restTemplate
                .postForObject("http://localhost:" + port + "/api/v1/rent" , rentalOptions, RentalResult.class);

        // then
        assertThat(response).isNotNull();
        assertThat(response.getDrivers().size()).isEqualTo(rentalOptions.getDrivers().size());
        List<String> responseDriverNames = response.getDrivers().stream().map(Driver::getName).collect(Collectors.toList());
        assertThat(responseDriverNames).containsExactlyElementsOf(requestDriverNames);
    }

    private RentalOptions createRentalOptionsSameAge() {
        List<Driver> drivers = List.of(
                new Driver("Linda", 2, "red"),
                new Driver("Lena", 5, "yellow"),
                new Driver("Robert De Niro", 31, "blue"),
                new Driver("Lara", 5, "red"));

        RentalOptions rentalOptions = new RentalOptions();
        rentalOptions.setDrivers(drivers);

        return rentalOptions;
    }

    private RentalOptions createRentalOptionsDifferentAge() {
        List<Driver> drivers = List.of(
                new Driver("Linda", 2, "red"),
                new Driver("Robert De Niro", 31, "blue"),
                new Driver("Lara", 5, "red"));

        RentalOptions rentalOptions = new RentalOptions();
        rentalOptions.setDrivers(drivers);

        return rentalOptions;
    }
}
