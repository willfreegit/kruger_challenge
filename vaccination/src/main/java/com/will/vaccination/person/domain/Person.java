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
    @ApiModelProperty(notes = "ADMIN ROLE: Identification (Cedula de identidad EC)", example = "0704787993", required = true)
    private String identification;
    @NotNull()
    @Column(name="name")
    @ApiModelProperty(notes = "ADMIN ROLE: Person names", example = "JUAN FERNANDO", required = true)
    private String name;
    @NotNull()
    @Column(name="lastname")
    @ApiModelProperty(notes = "ADMIN ROLE: Person last names", example = "PEREZ LOPEZ", required = true)
    private String lastname;
    @NotNull()
    @Column(name="email")
    @ApiModelProperty(notes = "ADMIN ROLE: Valid email", example = "AAA@HOTMAIL.COM", required = true)
    private String email;
    @Column(name="birthdate")
    @ApiModelProperty(notes = "EMPLOYEE ROLE: birthdate", example = "2022-05-06")
    private Date birthdate;
    @Column(name="address")
    @ApiModelProperty(notes = "EMPLOYEE ROLE: Valid email", example = "SUCRE Y GENERAL TORRES 10-70")
    private String address;
    @Column(name="phonenumber")
    @ApiModelProperty(notes = "EMPLOYEE ROLE: Valid email", example = "0999999999")
    private String phonenumber;
    @Column(name="fromdate")
    @ApiModelProperty(notes = "AUTOMATIC VALUE FIELD... DON'T SEND")
    private Timestamp fromdate = new Timestamp(System.currentTimeMillis());
    @Column(name="todate")
    @ApiModelProperty(notes = "AUTOMATIC VALUE FIELD... DON'T SEND")
    private Timestamp todate = Timestamp.valueOf("9999-12-31 00:00:00");

}
