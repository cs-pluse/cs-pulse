package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.entity.Award;

import java.util.List;

public interface AwardService {
    Award saveAward(Award award);
    List<Award> getAllAwards();
}