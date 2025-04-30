package org.wso2.cs.pulse.dto;

import java.time.LocalDate;
import java.util.List;

public class GameScoreResponseDTO {
    private String sessionName;
    private LocalDate sessionDate;
    private List<CriteriaDTO> criteria;

    public GameScoreResponseDTO(String sessionName, LocalDate sessionDate, List<CriteriaDTO> criteria) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.criteria = criteria;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public List<CriteriaDTO> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<CriteriaDTO> criteria) {
        this.criteria = criteria;
    }
}
