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
    private String type; //Team or Individual
    @Column(name = "abt_id")
    private Integer abtId;

    @Column(name = "session_id")
    private Integer sessionId;

    public Award() {
    }

    public Award(String awardName, String description, Integer abtId, Integer sessionId) {
        this.awardName = awardName;
        this.description = description;
        this.abtId = abtId;
        this.sessionId = sessionId;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
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

    public Integer getAbtId() {
        return abtId;
    }

    public void setAbtId(Integer abtId) {
        this.abtId = abtId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
}
