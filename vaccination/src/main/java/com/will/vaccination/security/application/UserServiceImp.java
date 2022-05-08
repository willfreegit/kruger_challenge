package com.will.vaccination.security.application;

import com.will.vaccination.role.domain.Roles;
import com.will.vaccination.role.domain.RoleRepo;
import com.will.vaccination.user.domain.Users;
import com.will.vaccination.user.domain.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users saveUser(Users user) {
        log.info("Save the new user...");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Roles saveRole(Roles role) {
        log.info("Save the new role {}...", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("Add role {} to {}...", username, rolename);
        Users user = userRepo.findByUsername(username);
        Roles role = roleRepo.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public Users getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Users> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);
        if(user == null){
            log.error("USER NOT FOUND!!!");
            throw new UsernameNotFoundException("Usuario no encontrado!!!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
