package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "award")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String awardName;

    private String description;

    private String type; // "Individual" or "Team"

    public Award() {
    }

    public Award(String awardName, String description, String type) {
        this.awardName = awardName;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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