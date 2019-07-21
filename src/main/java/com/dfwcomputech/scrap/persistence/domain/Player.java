package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {
	@Id
	@GeneratedValue(generator = "PLAYER_ID_GENERATOR")
	@SequenceGenerator(name = "PLAYER_ID_GENERATOR", sequenceName = "PLAYER_SEQUENCE")
	private Integer id;

	@Column(name = "PESDBID")
	private Integer pesdbId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "NATIONALITY")
	private String nationality;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPesdbId() {
		return pesdbId;
	}
	public void setPesdbId(Integer pesdbId) {
		this.pesdbId = pesdbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
