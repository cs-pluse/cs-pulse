package org.wso2.cs.pulse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wso2.cs.pulse.entity.ABT;
import org.wso2.cs.pulse.repository.ABTRepository;
import org.wso2.cs.pulse.service.ABTService;

import java.util.List;
import java.util.Optional;

@Service
public class ABTServiceImpl implements ABTService
{

    @Autowired
    private final ABTRepository abtRepository;

    public ABTServiceImpl(final ABTRepository abtRepository) {
        this.abtRepository = abtRepository;
    }

    public ABT saveABT(ABT abt) {
        return abtRepository.save(abt);
    }

    public void deleteABT(Long id) {
        abtRepository.deleteById(id);
    }

    public Optional<ABT> getABTById(Long id) {
        return abtRepository.findById(id);
    }

    public List<ABT> getABTs() {
        return abtRepository.findAll();
    }

    public List<ABT> findByABTName(String name) {
        return abtRepository.findByABTName(name);
    }

    public void updateABT(ABT abt) {
        abtRepository.save(abt);
    }

}
