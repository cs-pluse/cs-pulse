package org.wso2.cs.pulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wso2.cs.pulse.entity.TeamAward;

@Repository
public interface TeamAwardRepository extends JpaRepository<TeamAward, Long> {
}
