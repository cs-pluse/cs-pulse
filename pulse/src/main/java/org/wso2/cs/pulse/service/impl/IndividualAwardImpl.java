package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.IndividualAward;
import org.wso2.cs.pulse.repository.IndividualAwardRepository;
import org.wso2.cs.pulse.service.IndividualAwardService;

import java.util.List;
import java.util.Optional;

@Service
public class IndividualAwardImpl implements IndividualAwardService {

    private final IndividualAwardRepository individualAwardRepository;

    @Autowired
    public IndividualAwardImpl(IndividualAwardRepository individualAwardRepository) {
        this.individualAwardRepository = individualAwardRepository;
    }

    @Override
    public IndividualAward saveIndividualAward(IndividualAward individualAward) {
        return individualAwardRepository.save(individualAward);
    }

    @Override
    public List<IndividualAward> getAllIndividualAwards() {
        return individualAwardRepository.findAll();
    }

    @Override
    public IndividualAward getIndividualAwardById(Long id) {
        Optional<IndividualAward> optional = individualAwardRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void deleteIndividualAward(Long id) {
        individualAwardRepository.deleteById(id);
    }
}
