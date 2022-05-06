package com.will.vaccination.person.infrastructure;

import com.will.vaccination.person.application.PersonService;
import com.will.vaccination.person.application.ValidatePersonInputData;
import com.will.vaccination.person.domain.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person) {
        if(!ValidatePersonInputData.validateRequieredFields(person.getIdentification(), person.getName(), person.getLastname(), person.getEmail())){
            return ResponseEntity.ok().body("Los campos cedula, nombre, apellido y email son obligatorios");
        }
        personService.insertPerson(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
