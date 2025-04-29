package org.wso2.cs.pulse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wso2.cs.pulse.entity.TeamAward;
import org.wso2.cs.pulse.service.TeamAwardService;

import java.util.List;

@RestController
@RequestMapping("/api/team-awards")
public class TeamAwardController {

    private final TeamAwardService teamAwardService;

    @Autowired
    public TeamAwardController(TeamAwardService teamAwardService) {
        this.teamAwardService = teamAwardService;
    }

    @PostMapping
    public TeamAward createTeamAward(@RequestBody TeamAward teamAward) {
        return teamAwardService.saveTeamAward(teamAward);
    }

    @GetMapping
    public List<TeamAward> getAllTeamAwards() {
        return teamAwardService.getAllTeamAwards();
    }

    @GetMapping("/{id}")
    public TeamAward getTeamAwardById(@PathVariable Long id) {
        return teamAwardService.getTeamAwardById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamAward(@PathVariable Long id) {
        teamAwardService.deleteTeamAward(id);
    }
}
