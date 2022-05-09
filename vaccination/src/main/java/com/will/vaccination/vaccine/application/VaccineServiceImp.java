package com.will.vaccination.vaccine.application;

import com.will.vaccination.person.domain.Person;
import com.will.vaccination.vaccine.domain.Vaccine;
import com.will.vaccination.vaccine.domain.VaccineRepository;
import com.will.vaccination.vaccine.domain.Vaccine_Person;
import com.will.vaccination.vaccine.domain.Vaccine_PersonRepository;
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
    private final Vaccine_PersonRepository vaccine_personRepository;

    @Override
    public List<Vaccine> getVaccineList() {
        return vaccineRepository.findAll();
    }

    @Override
    public void saveVaccinePerson(Vaccine_Person vaccine_person) {
        vaccine_personRepository.save(vaccine_person);
    }

    @Override
    public List<Person> getByState() {
        return null;
    }


}
