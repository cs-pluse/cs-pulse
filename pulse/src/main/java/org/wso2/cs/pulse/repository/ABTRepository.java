package org.wso2.cs.pulse.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wso2.cs.pulse.entity.ABT;

import java.util.List;

@Transactional
@Repository
public interface ABTRepository extends JpaRepository<ABT, Long> {

    @Query(value = "SELECT * FROM abt WHERE abt_name = :name", nativeQuery = true)
    List<ABT> findByABTName(@Param("name") String name);

}
