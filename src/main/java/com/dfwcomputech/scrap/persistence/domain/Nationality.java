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
@Table(name="Nationality")
public class Nationality {
	@Id
	@GeneratedValue(generator = "NATIONALITY_ID_GENERATOR")
	@SequenceGenerator(name = "NATIONALITY_ID_GENERATOR", sequenceName = "NATIONALITY_SEQUENCE")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="REGIONID")
	private Region region;

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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
		
}
