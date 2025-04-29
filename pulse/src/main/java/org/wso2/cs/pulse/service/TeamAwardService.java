package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.TeamAward;

import java.util.List;

public interface TeamAwardService {
    TeamAward saveTeamAward(TeamAward teamAward);
    List<TeamAward> getAllTeamAwards();
    TeamAward getTeamAwardById(Long id);
    void deleteTeamAward(Long id);
}
