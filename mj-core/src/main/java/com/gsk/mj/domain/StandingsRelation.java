package com.gsk.mj.domain;


import javax.persistence.*;

@Table(name = "T_GX_STANDINGSRELATION")
@Entity
public class StandingsRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer standingsId;

    private Integer standingsdetailId;

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

    public Integer getStandingsdetailId() {
        return standingsdetailId;
    }

    public void setStandingsdetailId(Integer standingsdetailId) {
        this.standingsdetailId = standingsdetailId;
    }
}