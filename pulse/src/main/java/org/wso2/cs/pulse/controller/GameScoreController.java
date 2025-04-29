package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.dto.GameScoreResponseDTO;
import org.wso2.cs.pulse.entity.GameScore;
import org.wso2.cs.pulse.service.GameScoreService;

import java.util.List;

@RestController
@RequestMapping("/pulse/gamescore")
public class GameScoreController {

    @Autowired
    private GameScoreService gameScoreService;

    @PostMapping
    public ResponseEntity<GameScore> createGameScore(@RequestBody GameScore gameScore) {
        GameScore savedGameScore = gameScoreService.saveGameScore(gameScore);
        return ResponseEntity.ok(savedGameScore);
    }

    @GetMapping
    public ResponseEntity<List<GameScoreResponseDTO>> getAllGameScores() {
        List<GameScoreResponseDTO> gameScores = gameScoreService.getAllGameScores();
        return ResponseEntity.ok(gameScores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameScore> getGameScoreById(@PathVariable Long id) {
        return gameScoreService.getGameScoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameScore> updateGameScore(@PathVariable Long id, @RequestBody GameScore newGameScore) {
        return gameScoreService.getGameScoreById(id)
                .map(gameScore -> {
                    return ResponseEntity.ok(gameScoreService.saveGameScore(gameScore));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGameScore(@PathVariable Long id) {
        return gameScoreService.getGameScoreById(id)
                .map(gameScore -> {
                    gameScoreService.deleteGameScore(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
