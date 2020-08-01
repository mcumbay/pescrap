package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team {

	@Id
	@GeneratedValue(generator = "TEAM_ID_GENERATOR")
	@SequenceGenerator(name = "TEAM_ID_GENERATOR", sequenceName = "TEAM_SEQUENCE",allocationSize=1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="LEAGUEID", nullable = false)
	private League league;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	
}
