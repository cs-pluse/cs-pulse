package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.Award;
import org.wso2.cs.pulse.repository.AwardRepository;
import org.wso2.cs.pulse.service.AwardService;

import java.util.List;
import java.util.Optional;

@Service
public class AwardImpl implements AwardService {

    private final AwardRepository awardRepository;

    @Autowired
    public AwardImpl(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }

    @Override
    public Award saveAward(Award award) {
        return awardRepository.save(award);
    }

    @Override
    public List<Award> getAllAwards() {
        return awardRepository.findAll();
    }

    @Override
    public Award getAwardById(Integer id) {
        Optional<Award> optional = awardRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteAward(Integer id) {
        awardRepository.deleteById(id);
    }
}
