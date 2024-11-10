package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DoctorRegistrationData data, UriComponentsBuilder uriBuilder){
        var doctor = new Doctor(data);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetailsData(doctor));
    }
    @GetMapping
    public ResponseEntity<Page<ListDoctorData>> doctorsList(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var list = doctorRepository.findAllByActiveTrue(pagination).map(ListDoctorData::new);

        return  ResponseEntity.ok(list);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateData data, @PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.updateAttributes(data);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.desable();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);

        return ResponseEntity.ok(new DoctorDetailsData(doctor));
    }

}
