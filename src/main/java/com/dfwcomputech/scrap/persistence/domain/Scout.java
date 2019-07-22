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
@Table(name="SCOUT")
public class Scout {

	@Id
	@GeneratedValue(generator = "SCOUT_ID_GENERATOR")
	@SequenceGenerator(name = "SCOUT_ID_GENERATOR", sequenceName = "SCOUT_SEQUENCE")
	@Column(name="ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="patchId")
	private Patch patch;
	
	@ManyToOne
	@JoinColumn(name = "playerId")
	private Player player;
	
	@Column(name="CHANCE")
	private Integer chance;
	
	@Column(name="SCOUTLEVEL")
	private Integer level;
	
	@Column(name="SCOUT1")
	private String scout1;
	
	@Column(name="SCOUT2")
	private String scout2;
	
	@Column(name="SCOUT3")
	private String scout3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patch getPatch() {
		return patch;
	}

	public void setPatch(Patch patch) {
		this.patch = patch;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getChance() {
		return chance;
	}

	public void setChance(Integer chance) {
		this.chance = chance;
	}

	public String getScout1() {
		return scout1;
	}

	public void setScout1(String scout1) {
		this.scout1 = scout1;
	}

	public String getScout2() {
		return scout2;
	}

	public void setScout2(String scout2) {
		this.scout2 = scout2;
	}

	public String getScout3() {
		return scout3;
	}

	public void setScout3(String scout3) {
		this.scout3 = scout3;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
