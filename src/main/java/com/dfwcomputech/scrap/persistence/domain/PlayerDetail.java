package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER_DETAIL")
public class PlayerDetail {
	@EmbeddedId
	private PlayerDetailId id;
	@Column(name="SQUATNUMBER")
	private Integer squatNumber;
	@Column(name="HEIGHT")
	private Integer height;
	@Column(name="WEIGHT")
	private Integer weight;
	@Column(name="AGE")
	private Integer age;
	@Column(name="FOOT")
	private String foot;
	@Column(name="CONDITION")
	private String currentCondition;
		
	@Column(name="RATING")
	private Integer oprAtLevel30;
	
	@Column(name="TEAM")
	private String team;
	@Column(name="LEAGUE")
	private String league;	
	
	@ManyToOne
	@JoinColumn(name="POSITIONID")
	private Position preferedPosition;
		
	@ManyToOne
	@JoinColumn(name = "PLAYINGSTYLEID")
	private PlayingStyle playingStyle;
	
	public PlayerDetailId getId() {
		return id;
	}
	public void setId(PlayerDetailId id) {
		this.id = id;
	}
	public Integer getSquatNumber() {
		return squatNumber;
	}
	public void setSquatNumber(Integer squatNumber) {
		this.squatNumber = squatNumber;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	public String getCurrentCondition() {
		return currentCondition;
	}
	public void setCurrentCondition(String currentCondition) {
		this.currentCondition = currentCondition;
	}
	public Position getPreferedPosition() {
		return preferedPosition;
	}
	public void setPreferedPosition(Position preferedPosition) {
		this.preferedPosition = preferedPosition;
	}
	public Integer getOprAtLevel30() {
		return oprAtLevel30;
	}
	public void setOprAtLevel30(Integer oprAtLevel30) {
		this.oprAtLevel30 = oprAtLevel30;
	}
	public PlayingStyle getPlayingStyle() {
		return playingStyle;
	}
	public void setPlayingStyle(PlayingStyle playingStyle) {
		this.playingStyle = playingStyle;
	}

		
}
