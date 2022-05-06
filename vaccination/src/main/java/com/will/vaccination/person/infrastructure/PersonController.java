package com.will.vaccination.person.infrastructure;

import com.will.vaccination.person.application.PersonService;
import com.will.vaccination.person.application.ValidatePersonInputData;
import com.will.vaccination.person.domain.Person;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;

    @GetMapping("/getAllPersons")
    @ApiOperation(value = "Get all persons on database only from admin test")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    @ApiOperation(value = "Add a new person with required fields: identification, name, lastname and email")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Person created"),
            @ApiResponse(code = 400, message = "The request object doesn't passed the validations")
    })
    public ResponseEntity addPerson(@RequestBody Person person) {
        if(!ValidatePersonInputData.validateRequieredFields(person.getIdentification(), person.getName(), person.getLastname(), person.getEmail())){
            return new ResponseEntity("Fields identification, name, lastname and email are required", HttpStatus.BAD_REQUEST);
        } else {
            if(!ValidatePersonInputData.validateCedula(person.getIdentification())){
                return new ResponseEntity("Incorrect identification", HttpStatus.BAD_REQUEST);
            } else {
                if(!ValidatePersonInputData.validateEmail(person.getEmail())){
                    return new ResponseEntity("Incorrect Email", HttpStatus.BAD_REQUEST);
                } else {
                    if(!ValidatePersonInputData.validateNames(person.getName()) || !ValidatePersonInputData.validateNames(person.getLastname())){
                        return new ResponseEntity("The name and last name cannot contains numbers or special characters", HttpStatus.BAD_REQUEST);
                    }
                }
            }
        }
        personService.insertPerson(person);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
