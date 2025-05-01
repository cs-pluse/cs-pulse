package org.wso2.cs.pulse.dto;

import java.time.LocalDate;
import java.util.List;

public class GameScoreResponseDTO {
    private String sessionName;
    private LocalDate sessionDate;
    private List<CriteriaDTO> criteria;
    private List<AwardDTO> awards;

    public GameScoreResponseDTO(String sessionName, LocalDate sessionDate, List<CriteriaDTO> criteria,  List<AwardDTO> awards) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.criteria = criteria;
        this.awards = awards;
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

    public List<AwardDTO> getAwards() {
        return awards;
    }

    public void setAwards(List<AwardDTO> awards) {
        this.awards = awards;
    }
}
