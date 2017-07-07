package com.gsk.mj.domain;

import javax.persistence.*;

@Entity
@Table(name = "T_YW_PLAYRECORD")
public class PlayRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer standingsdetailId;

    private String playrecord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandingsdetailId() {
        return standingsdetailId;
    }

    public void setStandingsdetailId(Integer standingsdetailId) {
        this.standingsdetailId = standingsdetailId;
    }

    public String getPlayrecord() {
        return playrecord;
    }

    public void setPlayrecord(String playrecord) {
        this.playrecord = playrecord == null ? null : playrecord.trim();
    }
}