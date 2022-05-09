package com.will.vaccination.person.application;

import com.will.vaccination.exception.EmployeeNotFoundException;
import com.will.vaccination.person.domain.Person;
import com.will.vaccination.person.domain.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImp implements PersonService{

    private PersonRepository personRepository;
    public boolean insertPerson(Person person) {
        personRepository.save(person);
        return true;
    }
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(String id){
        return personRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Person> findVaccinatedPerson() {
        return personRepository.findVaccinatedPerson();
    }

    @Override
    public List<Person> findNoVaccinatedPerson() {
        return personRepository.findNoVaccinatedPerson();
    }

    @Override
    public List<Person> findByVaccineType(long type) {
        return personRepository.findByVaccineType(type);
    }

    @Override
    public List<Person> findByVaccineDate(Date finicio, Date ffin) {
        return personRepository.findByVaccineDate(finicio, ffin);
    }
}
