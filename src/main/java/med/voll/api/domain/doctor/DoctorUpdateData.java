package med.voll.api.domain.doctor;

import med.voll.api.domain.address.AddressData;

public record DoctorUpdateData(
        String name,
        String email,
        String phone,
        Specialty specialty,
        AddressData address
) {}
