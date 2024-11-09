package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void register( @RequestBody @Valid DoctorRegistrationData data){
        doctorRepository.save(new Doctor(data));
    }
    @GetMapping
    public Page<ListDoctorData> doctorsList(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return doctorRepository.findAllByActiveTrue(pagination).map(ListDoctorData::new);
    }
    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DoctorUpdateData data){
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateAttributes(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var doctor = doctorRepository.getReferenceById(id);
        doctor.desable();
    }

}
