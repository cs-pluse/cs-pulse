package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.Criteria;
import org.wso2.cs.pulse.repository.CriteriaRepository;
import org.wso2.cs.pulse.service.CriteriaService;

import java.util.List;
import java.util.Optional;

@Service
public class CriteriaServiceImpl implements CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public Criteria saveCriteria(Criteria criteria) {
        return criteriaRepository.save(criteria);
    }

    @Override
    public List<Criteria> getAllCriteria() {
        return criteriaRepository.findAll();
    }

    @Override
    public Optional<Criteria> getCriteriaById(Integer id) {
        return criteriaRepository.findById(id);
    }
}
