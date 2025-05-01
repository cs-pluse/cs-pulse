package org.wso2.cs.pulse.dto;

public class AwardDTO {
    private String awardName;
    private String description;
    private String type;

    public AwardDTO(String awardName, String description, String type) {
        this.awardName = awardName;
        this.description = description;
        this.type = type;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}