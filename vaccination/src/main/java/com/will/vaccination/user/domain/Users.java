package com.will.vaccination.user.domain;

import com.will.vaccination.role.domain.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String username;
    private String password;
    private String oldpassword;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles = new ArrayList<>();
}
