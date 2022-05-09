package com.will.vaccination.person.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    @Query(value = "select * from person where identification in (select distinct(identification) from vaccine_person)", nativeQuery = true)
    public List<Person> findVaccinatedPerson();
    @Query(value = "select * from person where identification not in (select distinct(identification) from vaccine_person)", nativeQuery = true)
    public List<Person> findNoVaccinatedPerson();
    @Query(value = "select * from person where identification in (select distinct(identification) from vaccine_person where vaccine_id = :type)", nativeQuery = true)
    public List<Person> findByVaccineType(@Param("type") long type);
    @Query(value = "select * from person where identification in (select distinct(identification) from vaccine_person where date_of_vaccine between :finicio and :ffin)", nativeQuery = true)
    public List<Person> findByVaccineDate(@Param("finicio") Date finicio, @Param("ffin") Date ffin);


}