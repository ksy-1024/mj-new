package com.gsk.mj.domain;

import javax.persistence.*;

@Table(name = "T_YW_PRIZARULE")
@Entity
public class PrizeRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    private Integer precount;
    
    private String status;
    
    
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getPrecount() {
        return precount;
    }

    public void setPrecount(Integer precount) {
        this.precount = precount;
    }
}