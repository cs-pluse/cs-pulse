package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.dto.AwardDTO;
import org.wso2.cs.pulse.dto.CriteriaDTO;
import org.wso2.cs.pulse.dto.GameScoreResponseDTO;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.entity.GameScore;
import org.wso2.cs.pulse.repository.AwardRepository;
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

    @Autowired
    private AwardRepository awardRepository;

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

        Integer latestSessionId = latestScores.get(0).getSession().getId();

        return latestScores.stream()
                .collect(Collectors.groupingBy(
                        gs -> gs.getAbt().getAbtName(),
                        Collectors.collectingAndThen(Collectors.toList(), scores -> {
                            GameScore first = scores.get(0); // all scores same session, same ABT

                            List<CriteriaDTO> criteriaList = scores.stream()
                                    .map(gs -> new CriteriaDTO(gs.getCriteria().getName(), gs.getCriteria().getPoints()))
                                    .collect(Collectors.toList());

                            // Get awards only for this ABT and latest session
                            List<Award> awards = awardRepository.findByAbtIdAndSessionId(
                                    first.getAbt().getId(), latestSessionId
                            );

                            List<AwardDTO> awardList = awards.stream()
                                    .map(a -> new AwardDTO(a.getAwardName(), a.getDescription(), a.getType()))
                                    .collect(Collectors.toList());

                            return new GameScoreResponseDTO(
                                    first.getSession().getName(),
                                    first.getSession().getDate(),
                                    criteriaList,
                                    awardList
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
