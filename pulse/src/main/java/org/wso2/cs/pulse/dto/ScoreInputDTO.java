package org.wso2.cs.pulse.dto;

import java.util.List;

public class ScoreInputDTO {
    private int sessionId;
    private Long abtId;
    private List<CriteriaScoreDTO> criteriaScores;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public Long getAbtId() {
        return abtId;
    }

    public void setAbtId(Long abtId) {
        this.abtId = abtId;
    }

    public List<CriteriaScoreDTO> getCriteriaScores() {
        return criteriaScores;
    }

    public void setCriteriaScores(List<CriteriaScoreDTO> criteriaScores) {
        this.criteriaScores = criteriaScores;
    }
}