package com.will.vaccination.role.infrastructure;


import com.will.vaccination.security.application.UserService;
import com.will.vaccination.security.domain.RoleToUserFrom;
import com.will.vaccination.role.domain.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final UserService userService;

    /*@PostMapping("/save")
    public ResponseEntity<Roles> saveRole(@RequestBody Roles role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }*/

    @PostMapping("/addToUser")
    public ResponseEntity<Roles> saveRole(@RequestBody RoleToUserFrom roleToUserFrom) {
        userService.addRoleToUser(roleToUserFrom.getUsername(), roleToUserFrom.getRoleName());
        return ResponseEntity.ok().build();
    }
}

