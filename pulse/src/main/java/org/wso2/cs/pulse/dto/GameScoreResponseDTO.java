package org.wso2.cs.pulse.dto;

import java.time.LocalDate;
import java.util.List;

public class GameScoreResponseDTO {
    private String sessionName;
    private LocalDate sessionDate;
    private List<CriteriaDTO> criteria;
    private List<AwardDTO> awards;
    private int technicalExecution;
    private int customerInteraction;
    private int processEfficiency;
    private int bonusPoints;
    private int totalScore;

    public GameScoreResponseDTO(String sessionName, LocalDate sessionDate, List<CriteriaDTO> criteria,  List<AwardDTO> awards, int technicalExecution, int customerInteraction, int processEfficiency, int bonusPoints, int totalScore) {
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.criteria = criteria;
        this.awards = awards;
        this.technicalExecution = technicalExecution;
        this.customerInteraction = customerInteraction;
        this.processEfficiency = processEfficiency;
        this.bonusPoints = bonusPoints;
        this.totalScore = totalScore;

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

    public int getTechnicalExecution() {
        return technicalExecution;
    }
    public void setTechnicalExecution(int technicalExecution) {
        this.technicalExecution = technicalExecution;
    }
    public int getCustomerInteraction() {
        return customerInteraction;
    }
    public void setCustomerInteraction(int customerInteraction) {
        this.customerInteraction = customerInteraction;
    }
    public int getProcessEfficiency() {
        return processEfficiency;
    }
    public void setProcessEfficiency(int processEfficiency) {
        this.processEfficiency = processEfficiency;
    }
    public int getBonusPoints() {
        return bonusPoints;
    }
    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
