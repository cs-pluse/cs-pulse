package org.wso2.cs.pulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wso2.cs.pulse.entity.Award;

public interface AwardRepository extends JpaRepository<Award, Integer> {
}