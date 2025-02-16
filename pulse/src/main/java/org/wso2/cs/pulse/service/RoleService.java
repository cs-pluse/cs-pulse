package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role saveRole(Role role);

    void deleteRole(Long id);

    Optional<Role> getRoleById(Long id);

    List<Role> getRoles();

    List<Role> findByRoleName(String name);

}
