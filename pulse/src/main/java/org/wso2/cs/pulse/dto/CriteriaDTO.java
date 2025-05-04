package org.wso2.cs.pulse.dto;

public class CriteriaDTO {
    private String name;
    private int maxPoints;      // From criteria.points
    private int earnedPoints;   // From game_scores.score

    public CriteriaDTO(String name, int maxPoints, int earnedPoints) {
        this.name = name;
        this.maxPoints = maxPoints;
        this.earnedPoints = earnedPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    public int getEarnedPoints() {
        return earnedPoints;
    }
    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

}