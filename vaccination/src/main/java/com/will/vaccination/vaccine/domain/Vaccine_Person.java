package com.will.vaccination.vaccine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine_Person {

    @EmbeddedId
    private Vaccine_Person_Id vaccine_person_id;

    private Date date_of_vaccine;
}
