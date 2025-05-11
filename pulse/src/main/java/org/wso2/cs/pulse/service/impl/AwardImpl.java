package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.repository.AwardRepository;
import org.wso2.cs.pulse.service.AwardService;

import java.util.List;

@Service
public class AwardImpl implements AwardService {

    @Autowired
    private AwardRepository awardRepository;

    @Override
    public Award saveAward(Award award) {
        return awardRepository.save(award);
    }

    @Override
    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }
}