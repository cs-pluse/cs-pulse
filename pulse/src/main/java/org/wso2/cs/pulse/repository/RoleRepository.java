package org.wso2.cs.pulse.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.wso2.cs.pulse.entity.Role;

import java.util.List;

@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM role WHERE role_name = :name", nativeQuery = true)
    List<Role> findByRoleName(String name);

}
