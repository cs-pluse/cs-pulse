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
    private Integer abt_id;

    public Award() {
    }

    public Award(String awardName, String description, Integer abt_id) {
        this.awardName = awardName;
        this.description = description;
        this.abt_id = abt_id;
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

    public Integer getAbt() {
        return abt_id;
    }

    public void setAbt(Integer abt_id) {
        this.abt_id = abt_id;
    }
}
