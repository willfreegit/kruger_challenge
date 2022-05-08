package com.will.vaccination.vaccine.infrastructure;

import com.will.vaccination.vaccine.application.VaccineService;
import com.will.vaccination.vaccine.domain.Vaccine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    @GetMapping("/getAllVaccines")
    public ResponseEntity<List<Vaccine>> getAllVaccines(){
        return new ResponseEntity<>(vaccineService.getVaccineList(), HttpStatus.OK);
    }
}
