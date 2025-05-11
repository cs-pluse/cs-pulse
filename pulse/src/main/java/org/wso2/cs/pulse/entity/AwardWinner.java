package org.wso2.cs.pulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "award_winner")
public class AwardWinner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String winnerName;

    @ManyToOne
    @JoinColumn(name = "award_id", referencedColumnName = "id")
    private Award award;

    @ManyToOne
    @JoinColumn(name = "abt_id", referencedColumnName = "id")
    private ABT abt;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    private Session session;

    public AwardWinner() {
    }

    public AwardWinner(String winnerName, Award award, ABT abt, Session session) {
        this.winnerName = winnerName;
        this.award = award;
        this.abt = abt;
        this.session = session;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    public ABT getAbt() {
        return abt;
    }

    public void setAbt(ABT abt) {
        this.abt = abt;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}