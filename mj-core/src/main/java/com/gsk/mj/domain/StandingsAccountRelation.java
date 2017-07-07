package com.gsk.mj.domain;

import javax.persistence.*;

@Table(name = "T_GX_STANDINGACCOUNT")
@Entity
public class StandingsAccountRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer standingsId;

    private Integer accountId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandingsId() {
        return standingsId;
    }

    public void setStandingsId(Integer standingsId) {
        this.standingsId = standingsId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}