package org.wso2.cs.pulse.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.wso2.cs.pulse.entity.GameScore;

import java.util.List;

@Transactional
@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
    @Query("SELECT gs FROM GameScore gs WHERE gs.session.date = (SELECT MAX(s.date) FROM Session s)")
    List<GameScore> findLatestSessionGameScores();
}
