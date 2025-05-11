package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.Criteria;

import java.util.List;
import java.util.Optional;

public interface CriteriaService {
    Criteria saveCriteria(Criteria criteria);
    List<Criteria> getAllCriteria();
    Optional<Criteria> getCriteriaById(Integer id);
}
