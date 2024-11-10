package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.AddressData;

public record DoctorRegistrationData(
        @NotBlank // Validations with bean validation
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        @Pattern(regexp = "\\d{8,14}")
        String phone,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressData address
) { }
