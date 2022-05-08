package com.will.vaccination.vaccine.application;

import com.will.vaccination.vaccine.domain.Vaccine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VaccineService {
    List<Vaccine> getVaccineList();
}
