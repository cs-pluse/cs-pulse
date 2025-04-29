package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game_score")
public class GameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String criteria;
    private Integer points;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "abt_id", referencedColumnName = "id")
    private ABT abt;

    public GameScore() {
    }

    public GameScore(String criteria, Integer points, Integer score, ABT abt) {
        this.criteria = criteria;
        this.points = points;
        this.score = score;
        this.abt = abt;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public ABT getAbt() {
        return abt;
    }

    public void setAbt(ABT abt) {
        this.abt = abt;
    }
}
