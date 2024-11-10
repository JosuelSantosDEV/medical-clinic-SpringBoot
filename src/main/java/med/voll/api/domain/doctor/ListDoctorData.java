package med.voll.api.domain.doctor;

public record ListDoctorData(Long id, String name, String email,String crm, Specialty specialty) {
    public ListDoctorData(Doctor doctor){
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getSpecialty()

        );

    }
}
