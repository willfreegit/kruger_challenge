package com.will.vaccination.security.application;

import com.will.vaccination.role.domain.Roles;
import com.will.vaccination.user.domain.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Users saveUser(Users user);
    Roles saveRole(Roles role);
    void addRoleToUser(String username, String rolename);
    Users getUser(String username);
    List<Users> getUsers();
}
