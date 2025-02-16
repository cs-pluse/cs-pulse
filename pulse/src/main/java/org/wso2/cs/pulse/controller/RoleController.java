package org.wso2.cs.pulse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wso2.cs.pulse.entity.Role;
import org.wso2.cs.pulse.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/pulse/role")
public class RoleController
{
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role abt) {
        return ResponseEntity.ok(roleService.saveRole(abt));
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<Role>> findByRoleName(@PathVariable String name) {
        List<Role> roles = roleService.findByRoleName(name);
        return ResponseEntity.ok(roles);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role newRole) {

        return roleService.getRoleById(id)
                .map(role -> {
                    role.setRoleName(newRole.getRoleName());
                    return ResponseEntity.ok(newRole);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        ResponseEntity<Object> objectResponseEntity = roleService.getRoleById(id)
                .map(abt -> {
                    roleService.deleteRole(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());

        if (objectResponseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info("Role with ID {} is deleted successfully", id);
        }
        return ResponseEntity.noContent().build();
    }
}
