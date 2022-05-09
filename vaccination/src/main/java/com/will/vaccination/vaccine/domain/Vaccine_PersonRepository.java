package com.will.vaccination.vaccine.domain;

import com.will.vaccination.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface Vaccine_PersonRepository extends JpaRepository<Vaccine_Person, Vaccine_Person_Id> {

}