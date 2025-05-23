package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.dto.GameScoreResponseDTO;
import org.wso2.cs.pulse.dto.ScoreInputDTO;
import org.wso2.cs.pulse.entity.GameScore;
import org.wso2.cs.pulse.service.GameScoreService;

import java.util.Map;

@RestController
@RequestMapping("/pulse/gamescore")
@CrossOrigin
public class GameScoreController {

    @Autowired
    private GameScoreService gameScoreService;

    @PostMapping
    public ResponseEntity<Void> createGameScores(@RequestBody ScoreInputDTO input) {
        gameScoreService.saveGameScores(input);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Map<String, GameScoreResponseDTO>> getLatestGameScores() {
        Map<String, GameScoreResponseDTO> response = gameScoreService.getLatestGameScoresGroupedByAbt();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameScore> getGameScoreById(@PathVariable Long id) {
        return gameScoreService.getGameScoreById(id)
                .map(ResponseEntity::ok)
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
