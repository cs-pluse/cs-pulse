package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.dto.GameScoreResponseDTO;
import org.wso2.cs.pulse.dto.ScoreInputDTO;
import org.wso2.cs.pulse.entity.GameScore;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface GameScoreService {

    void saveGameScores(ScoreInputDTO input);

    void deleteGameScore(Long id);

    Optional<GameScore> getGameScoreById(Long id);

    List<GameScore> findByCriteria(String criteria);

    void updateGameScore(GameScore gameScore);

    Map<String, GameScoreResponseDTO> getLatestGameScoresGroupedByAbt();
}
