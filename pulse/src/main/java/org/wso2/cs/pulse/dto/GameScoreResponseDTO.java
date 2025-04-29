package org.wso2.cs.pulse.dto;

public class GameScoreResponseDTO {
    private Integer id;
    private String criteriaName;
    private String sessionName;
    private String abtName;

    public GameScoreResponseDTO(Integer id, String criteriaName, String sessionName, String abtName) {
        this.id = id;
        this.criteriaName = criteriaName;
        this.sessionName = sessionName;
        this.abtName = abtName;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getAbtName() {
        return abtName;
    }

    public void setAbtName(String abtName) {
        this.abtName = abtName;
    }
}
