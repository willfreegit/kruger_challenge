package com.will.vaccination.Person;

import com.will.vaccination.person.domain.Person;
import com.will.vaccination.person.infrastructure.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonUnitTest {
    @Autowired
    PersonController personController;

    @Test
    public void addPersonWithIncompleteInformation(){
        Person person = new Person("0101","aaaa","bbb",null,null,null,null,null,null);
        assertEquals(HttpStatus.BAD_REQUEST,personController.addPerson(person).getStatusCode());
    }

    @Test
    public void addPersonWithIncorrectIdentification(){
        Person person = new Person("0101","aaaa","bbb","will@hotmail.com",null,null,null,null,null);
        assertEquals(HttpStatus.BAD_REQUEST,personController.addPerson(person).getStatusCode());
    }

    @Test
    public void addPersonWithIncorrectEmail(){
        Person person = new Person("0104112347","aaaa","bbb","aaa.bbb.ccc",null,null,null,null,null);
        assertEquals(HttpStatus.BAD_REQUEST,personController.addPerson(person).getStatusCode());
    }

    @Test
    public void addPersonWithWrongNames(){
        Person person = new Person("0104112347","1234","abè","wilson@hotmal.com",null,null,null,null,null);
        assertEquals(HttpStatus.BAD_REQUEST,personController.addPerson(person).getStatusCode());
    }

    @Test
    public void addPersonWithCorrectInformation(){
        Person person = new Person("0104112347","Wilson Vinicio","Monge Llivisaca","wmonge@hotmail.com",null,null,null,null,null);
        assertEquals(HttpStatus.CREATED,personController.addPerson(person).getStatusCode());
    }

}
