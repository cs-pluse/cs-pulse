package org.wso2.cs.pulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wso2.cs.pulse.entity.Award;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer> {
    List<Award> findByAbtIdAndSessionId(Integer abtId, Integer sessionId);
}
