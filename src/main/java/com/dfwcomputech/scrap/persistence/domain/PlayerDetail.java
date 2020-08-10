package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="PLAYER_DETAIL")
@Data
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
	
	@ManyToOne
	@JoinColumn(name="TEAMID")
	private Team team;
			
	@ManyToOne
	@JoinColumn(name="POSITIONID")
	private Position preferedPosition;
		
	@ManyToOne
	@JoinColumn(name = "PLAYINGSTYLEID")
	private PlayingStyle playingStyle;


	
}
