package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.IndividualAward;

import java.util.List;

public interface IndividualAwardService {
    IndividualAward saveIndividualAward(IndividualAward individualAward);
    List<IndividualAward> getAllIndividualAwards();
    IndividualAward getIndividualAwardById(Long id);
    void deleteIndividualAward(Long id);
}
