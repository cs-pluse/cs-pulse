package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.dto.CriteriaDTO;
import org.wso2.cs.pulse.dto.GameScoreResponseDTO;
import org.wso2.cs.pulse.entity.GameScore;
import org.wso2.cs.pulse.repository.GameScoreRepository;
import org.wso2.cs.pulse.service.GameScoreService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameScoreImpl implements GameScoreService {

    @Autowired
    private final GameScoreRepository gameScoreRepository;

    public GameScoreImpl(final GameScoreRepository gameScoreRepository) {
        this.gameScoreRepository = gameScoreRepository;
    }

    @Override
    public GameScore saveGameScore(GameScore gameScore) {
        return gameScoreRepository.save(gameScore);
    }

    @Override
    public void deleteGameScore(Long id) {
        gameScoreRepository.deleteById(id);
    }

    @Override
    public Optional<GameScore> getGameScoreById(Long id) {
        return gameScoreRepository.findById(id);
    }

    public Map<String, GameScoreResponseDTO> getLatestGameScoresGroupedByAbt() {
        List<GameScore> latestScores = gameScoreRepository.findLatestSessionGameScores();

        if (latestScores.isEmpty()) {
            return Collections.emptyMap();
        }

        return latestScores.stream()
                .collect(Collectors.groupingBy(
                        gs -> gs.getAbt().getAbtName(),
                        Collectors.collectingAndThen(Collectors.toList(), scores -> {
                            GameScore first = scores.get(0); // all scores have same session
                            List<CriteriaDTO> criteriaList = scores.stream()
                                    .map(gs -> new CriteriaDTO(gs.getCriteria().getName(), gs.getCriteria().getPoints()))
                                    .collect(Collectors.toList());

                            return new GameScoreResponseDTO(
                                    first.getSession().getName(),
                                    first.getSession().getDate(),
                                    criteriaList
                            );
                        })
                ));
    }

    @Override
    public List<GameScore> findByCriteria(String criteria) {
        return null;
    }

    @Override
    public void updateGameScore(GameScore gameScore) {
        gameScoreRepository.save(gameScore);
    }
}
