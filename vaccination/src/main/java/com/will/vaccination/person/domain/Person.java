package com.will.vaccination.person.domain;

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
    @Column(name="identification")
    private String identification;
    @Column(name="name")
    private String name;
    @Column(name="lastname")
    private String lastname;
    @Column(name="email")
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
