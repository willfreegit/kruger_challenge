package com.will.vaccination.person.domain;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @NotNull()
    @Column(name="identification")
    @ApiModelProperty(notes = "Identification (Cedula de identidad EC)", example = "0704787993", required = true)
    private String identification;
    @NotNull()
    @Column(name="name")
    @ApiModelProperty(notes = "Person names", example = "JUAN FERNANDO", required = true)
    private String name;
    @NotNull()
    @Column(name="lastname")
    @ApiModelProperty(notes = "Person last names", example = "PEREZ LOPEZ", required = true)
    private String lastname;
    @NotNull()
    @Column(name="email")
    @ApiModelProperty(notes = "Valid email", example = "AAA@HOTMAIL.COM", required = true)
    private String email;
    @Column(name="birthdate")
    private Date birthdate;
    @Column(name="address")
    private String address;
    @Column(name="phonenumber")
    private String phonenumber;
    @Column(name="fromdate")
    private Timestamp fromdate;
    @Column(name="todate")
    private Timestamp todate;

}
