package com.will.vaccination.person.infrastructure;

import com.will.vaccination.person.application.PersonService;
import com.will.vaccination.person.application.PersonServiceImp;
import com.will.vaccination.person.application.ValidatePersonInputData;
import com.will.vaccination.person.domain.Person;
import com.will.vaccination.security.application.UserService;
import com.will.vaccination.user.domain.Users;
import com.will.vaccination.vaccine.application.VaccineService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private PersonService personService;
    private UserService userService;
    private VaccineService vaccineService;

    @GetMapping("/getAllPersons")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get all persons on database only from admin test")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getPersonsById/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get person by identification")
    public ResponseEntity<List<Person>> getPersonsById(@PathVariable String id) {
        return new ResponseEntity(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/getPersonsByStateOfVaccine/{state}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get person by state of vaccine")
    public ResponseEntity<List<Person>> getPersonsByStateOfVaccine(@PathVariable String state) {
        if("YES".equals(state)){
            return new ResponseEntity(personService.findVaccinatedPerson(), HttpStatus.OK);
        } else {
            return new ResponseEntity(personService.findNoVaccinatedPerson(), HttpStatus.OK);
        }
    }

    @GetMapping("/getPersonsByVaccineType/{type}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get person by state of vaccine")
    public ResponseEntity<List<Person>> getPersonsByVaccineType(@PathVariable long type) {
        return new ResponseEntity(personService.findByVaccineType(type), HttpStatus.OK);

    }

    @GetMapping("/getPersonsByVaccineDate/{finicio}/{ffin}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Get person by state of vaccine")
    public ResponseEntity<List<Person>> getPersonsByVaccineType(@PathVariable Date finicio, @PathVariable Date ffin) {
        return new ResponseEntity(personService.findByVaccineDate(finicio, ffin), HttpStatus.OK);

    }

    @PostMapping("/addPerson")
    @PreAuthorize("hasAuthority('ADMIN')")
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
        Users user = new Users();
        user.setUsername(person.getIdentification());
        user.setPassword(person.getIdentification());
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/updatePerson")
    @PreAuthorize("hasAuthority('USER')")
    @ApiOperation(value = "Update person information: birthdate, address, cellphone number and ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Person updated"),
    })
    public ResponseEntity updatePerson(@RequestBody Person person) {
        Person newPerson = personService.findById(person.getIdentification());
        newPerson.setBirthdate(person.getBirthdate());
        newPerson.setPhonenumber(person.getPhonenumber());
        newPerson.setAddress(person.getAddress());
        personService.insertPerson(newPerson);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/addAdmin")
    @ApiOperation(value = "Add a new admin with required fields: country, identification, name, lastname and email." +
            "NO IMPLEMENT THIS API IN THE CLIENT SIDE, IS JUST TO ADD A NEW ADMIN...")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Person created")
    })
    public ResponseEntity addAdmin(@RequestBody Person person) {
        personService.insertPerson(person);
        Users user = new Users();
        user.setUsername(person.getIdentification());
        user.setPassword(person.getIdentification());
        userService.saveUser(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
