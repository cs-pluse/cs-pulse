package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.ABT;

import java.util.List;
import java.util.Optional;

public interface ABTService {

    ABT saveABT(ABT abt);

    void deleteABT(Long id);

    Optional<ABT> getABTById(Long id);

    List<ABT> getABTs();

    List<ABT> findByABTName(String name);

    void updateABT(ABT abt);

}
