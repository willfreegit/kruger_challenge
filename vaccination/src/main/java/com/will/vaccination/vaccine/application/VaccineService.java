package com.will.vaccination.vaccine.application;

import com.will.vaccination.person.domain.Person;
import com.will.vaccination.vaccine.domain.Vaccine;
import com.will.vaccination.vaccine.domain.Vaccine_Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VaccineService {
    List<Vaccine> getVaccineList();
    void saveVaccinePerson(Vaccine_Person vaccine_person);
    List<Person> getByState();
}
