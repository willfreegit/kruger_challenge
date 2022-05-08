package com.will.vaccination.vaccine.application;

import com.will.vaccination.vaccine.domain.Vaccine;
import com.will.vaccination.vaccine.domain.VaccineRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class VaccineServiceImp implements VaccineService{

    private final VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> getVaccineList() {
        return vaccineRepository.findAll();
    }
}
