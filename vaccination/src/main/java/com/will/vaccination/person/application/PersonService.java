package com.will.vaccination.person.application;

import com.will.vaccination.exception.EmployeeNotFoundException;
import com.will.vaccination.person.domain.Person;

import java.sql.Date;
import java.util.List;

public interface PersonService {
    public boolean insertPerson(Person person);
    public List<Person> findAll();
    public Person findById(String id);
    public List<Person> findVaccinatedPerson();
    public List<Person> findNoVaccinatedPerson();
    public List<Person> findByVaccineType(long type);
    public List<Person> findByVaccineDate(Date finicio, Date ffin);
}
