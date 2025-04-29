package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "individual_award")
public class IndividualAward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String awardName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "abt_id", referencedColumnName = "id")
    private ABT abt;

    public IndividualAward() {
    }

    public IndividualAward(String awardName, String description, ABT abt) {
        this.awardName = awardName;
        this.description = description;
        this.abt = abt;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

    public ABT getAbt() {
        return abt;
    }

    public void setAbt(ABT abt) {
        this.abt = abt;
    }
}
