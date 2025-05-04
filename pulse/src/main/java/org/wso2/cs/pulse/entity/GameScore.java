package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "game_score")
public class GameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "criteria_id", referencedColumnName = "id")
    private Criteria criteria;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "abt_id", referencedColumnName = "id")
    private ABT abt;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer score;

    public GameScore() {
    }
    // Constructors, Getters and Setters
    public GameScore(Criteria criteria, Session session, ABT abt, Integer score) {
        this.criteria = criteria;
        this.session = session;
        this.abt = abt;
        this.score = score;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public ABT getAbt() {
        return abt;
    }

    public void setAbt(ABT abt) {
        this.abt = abt;
    }

    public Integer getScore() { return score;}

    public void setScore(Integer score) { this.score = score;
    }
}
