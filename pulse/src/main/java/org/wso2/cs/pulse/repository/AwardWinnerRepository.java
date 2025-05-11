package org.wso2.cs.pulse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wso2.cs.pulse.entity.AwardWinner;

import java.util.List;

public interface AwardWinnerRepository extends JpaRepository<AwardWinner, Integer> {
    List<AwardWinner> findByAbtIdAndSessionId(Integer abtId, Integer sessionId);
}