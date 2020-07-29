package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PATCH")
public class Patch {
	@Id
	@GeneratedValue(generator = "PATCH_ID_GENERATOR")
	@SequenceGenerator(name = "PATCH_ID_GENERATOR", sequenceName = "PATCH_SEQUENCE",allocationSize=1)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "PESYEAR")
	private Integer pesYear;
	
	@Column(name = "DATAPACK")
	private Integer dataPack;
	
	@Column(name = "VERSION")
	private Integer version;
	
	@Column(name = "SUBVERSION")
	private Integer subversion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPesYear() {
		return pesYear;
	}

	public void setPesYear(Integer pesYear) {
		this.pesYear = pesYear;
	}

	public Integer getDataPack() {
		return dataPack;
	}

	public void setDataPack(Integer dataPack) {
		this.dataPack = dataPack;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getSubversion() {
		return subversion;
	}

	public void setSubversion(Integer subversion) {
		this.subversion = subversion;
	}

	
}
