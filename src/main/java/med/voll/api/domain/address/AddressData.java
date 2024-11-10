package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressData(
        @NotBlank
        String country,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String district,
        @NotBlank
        String street,
        @NotBlank
        @Pattern(regexp = "\\d{6,10}")
        String postalCode,
        String number,
        String complement
) {}
