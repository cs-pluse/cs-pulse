package org.wso2.cs.pulse.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.dto.AwardWinnerInputDTO;
import org.wso2.cs.pulse.entity.ABT;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.entity.AwardWinner;
import org.wso2.cs.pulse.entity.Session;
import org.wso2.cs.pulse.repository.ABTRepository;
import org.wso2.cs.pulse.repository.AwardRepository;
import org.wso2.cs.pulse.repository.AwardWinnerRepository;
import org.wso2.cs.pulse.repository.SessionRepository;
import org.wso2.cs.pulse.service.AwardWinnerService;

import java.util.List;

@Service
public class AwardWinnerServiceImpl implements AwardWinnerService {

    @Autowired
    private AwardWinnerRepository awardWinnerRepository;

    @Autowired
    private ABTRepository abtRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private AwardRepository awardRepository;

    @Override
    @Transactional
    public AwardWinner saveAwardWinner(AwardWinnerInputDTO input) {
        Award award = awardRepository.findById(input.getAwardId())
                .orElseThrow(() -> new RuntimeException("Award not found"));

        ABT abt = abtRepository.findById(input.getAbtId())
                .orElseThrow(() -> new RuntimeException("ABT not found"));

        Session session = sessionRepository.findById(input.getSessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));

        AwardWinner winner = new AwardWinner();
        winner.setAward(award);
        winner.setAbt(abt);
        winner.setSession(session);

        // For team awards, enforce "Team" as winner name
        if ("Team".equalsIgnoreCase(award.getType())) {
            winner.setWinnerName("Team");
        } else {
            // For individual awards, use the provided name
            if (input.getWinnerName() == null || input.getWinnerName().isEmpty()) {
                throw new IllegalArgumentException("Winner name must be provided for individual awards");
            }
            winner.setWinnerName(input.getWinnerName());
        }

        return awardWinnerRepository.save(winner);
    }

    @Override
    public List<AwardWinner> getAllAwardWinners() {
        return awardWinnerRepository.findAll();
    }
}