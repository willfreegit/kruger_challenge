package com.will.vaccination.vaccine.infrastructure;

import com.will.vaccination.vaccine.application.VaccineService;
import com.will.vaccination.vaccine.domain.Vaccine;
import com.will.vaccination.vaccine.domain.Vaccine_Person;
import com.will.vaccination.vaccine.domain.Vaccine_Person_Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping("/getAllVaccines")
    @PreAuthorize("hasAuthority('USER', 'ADMIN')")
    public ResponseEntity<List<Vaccine>> getAllVaccines(){
        return new ResponseEntity<>(vaccineService.getVaccineList(), HttpStatus.OK);
    }

    @PostMapping("/addVaccinationInfo")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity addVaccinationInfo(@RequestBody Vaccine_Person vaccine_person){
        vaccineService.saveVaccinePerson(vaccine_person);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
