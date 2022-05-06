package com.will.vaccination.person.application;

import com.will.vaccination.person.domain.Person;
import com.will.vaccination.person.domain.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    public boolean insertPerson(Person person) {
        personRepository.save(person);
        return true;
    }
}