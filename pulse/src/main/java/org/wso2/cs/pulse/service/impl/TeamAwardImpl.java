package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.TeamAward;
import org.wso2.cs.pulse.repository.TeamAwardRepository;
import org.wso2.cs.pulse.service.TeamAwardService;

import java.util.List;
import java.util.Optional;

@Service
public class TeamAwardImpl implements TeamAwardService {

    private final TeamAwardRepository teamAwardRepository;

    @Autowired
    public TeamAwardImpl(TeamAwardRepository teamAwardRepository) {
        this.teamAwardRepository = teamAwardRepository;
    }

    @Override
    public TeamAward saveTeamAward(TeamAward teamAward) {
        return teamAwardRepository.save(teamAward);
    }

    @Override
    public List<TeamAward> getAllTeamAwards() {
        return teamAwardRepository.findAll();
    }

    @Override
    public TeamAward getTeamAwardById(Long id) {
        Optional<TeamAward> optional = teamAwardRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteTeamAward(Long id) {
        teamAwardRepository.deleteById(id);
    }
}
