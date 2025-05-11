package org.wso2.cs.pulse.dto;

public class AwardWinnerInputDTO {
    private int awardId;
    private long abtId;
    private int sessionId;
    private String winnerName; // "Team" for team awards

    public int getAwardId() {
        return awardId;
    }

    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }

    public long getAbtId() {
        return abtId;
    }

    public void setAbtId(long abtId) {
        this.abtId = abtId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }
}
