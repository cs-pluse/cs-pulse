package org.wso2.cs.pulse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "abt")
public class ABT
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abtName;

    private String businessUnit;

    public ABT() {
    }

    public ABT(String abtName, String businessUnit) {
        this.abtName = abtName;
        this.businessUnit = businessUnit;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getAbtName() {
        return abtName;
    }

    public void setAbtName(String abtName) {
        this.abtName = abtName;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }






}
