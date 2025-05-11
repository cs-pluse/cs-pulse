package org.wso2.cs.pulse.dto;

import org.wso2.cs.pulse.entity.AwardWinner;

public class AwardWinnerResponseDTO {
    private String winnerName;
    private String awardName;
    private String abtName;
    private String sessionName;

    public AwardWinnerResponseDTO(AwardWinner winner) {
        this.winnerName = winner.getWinnerName();
        this.awardName = winner.getAward().getAwardName();
        this.abtName = winner.getAbt().getAbtName();
        this.sessionName = winner.getSession().getName();
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAbtName() {
        return abtName;
    }

    public void setAbtName(String abtName) {
        this.abtName = abtName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }
}