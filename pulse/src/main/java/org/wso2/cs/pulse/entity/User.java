package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user") // "user" is a reserved keyword in some databases
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    @Column(name = "abt_id")
    private Integer abtId;

    public User() {}

    public User(String name, String email, Integer abtId) {
        this.name = name;
        this.email = email;
        this.abtId = abtId;
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAbtId() {
        return abtId;
    }

    public void setAbtId(Integer abtId) {
        this.abtId = abtId;
    }
}
