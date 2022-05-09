package com.will.vaccination.vaccine.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vaccine_Person_Id implements Serializable {
    private int vaccine_id;
    private String identification;
    private int number_of_vaccine;
}
