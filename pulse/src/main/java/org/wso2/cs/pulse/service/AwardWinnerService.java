package org.wso2.cs.pulse.service;

import org.wso2.cs.pulse.dto.AwardWinnerInputDTO;
import org.wso2.cs.pulse.entity.AwardWinner;

import java.util.List;

public interface AwardWinnerService {
    AwardWinner saveAwardWinner(AwardWinnerInputDTO awardWinner);
    List<AwardWinner> getAllAwardWinners();
}