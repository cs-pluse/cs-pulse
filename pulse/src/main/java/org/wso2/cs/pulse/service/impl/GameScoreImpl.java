package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.GameScore;
import org.wso2.cs.pulse.repository.GameScoreRepository;
import org.wso2.cs.pulse.service.GameScoreService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<GameScore> getAllGameScores() {
        return gameScoreRepository.findAll();
    }

    @Override
    public List<GameScore> findByCriteria(String criteria) {
        return gameScoreRepository.findByCriteria(criteria);
    }

    @Override
    public void updateGameScore(GameScore gameScore) {
        gameScoreRepository.save(gameScore);
    }
}
