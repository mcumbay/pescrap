package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ABILITY_LEVEL")
@Data
public class Ability {

	@EmbeddedId
	private AbilityId id;

	@Column(name = "OFFENSIVEAWARENESS")
	private Integer offensiveAwareness;
	@Column(name = "BALLCONTROL")
	private Integer ballControl;
	@Column(name = "DRIBBLING")
	private Integer dribbling;
	@Column(name = "TIGHTPOSSESSION")
	private Integer tightPossession;
	@Column(name = "LOWPASS")
	private Integer lowPass;
	@Column(name = "LOFTEDPASS")
	private Integer loftedPass;
	@Column(name = "FINISHING")
	private Integer finishing;
	@Column(name = "HEADING")
	private Integer heading;	
	@Column(name = "PLACEKICKING")
	private Integer placeKicking;
	@Column(name = "CURL")
	private Integer curl;
	
	@Column(name = "SPEED")
	private Integer speed;
	@Column(name = "ACCELERATION")
	private Integer acceleration;
	@Column(name = "KICKINGPOWER")
	private Integer kickingPower;
	@Column(name = "JUMP")
	private Integer jump;
	
	@Column(name = "PHYSICALCONTACT")
	private Integer physicalContact;
	@Column(name = "BALANCE") 
	private Integer balance;
	@Column(name = "STAMINA")
	private Integer stamina;
	
	@Column(name = "DEFENSIVEAWARENESS")
	private Integer defensiveAwareness;	
	@Column(name = "BALLWINNING")
	private Integer ballWinning;	
	@Column(name = "AGGRESSION")
	private Integer aggression;
	
	@Column(name = "GKAWARENESS")
	private Integer gkAwareness;
	@Column(name = "GKCATCHING")
	private Integer gkcatching;
	@Column(name = "GKCLEARING")
	private Integer gkClearing;
	@Column(name = "GKREFLEXES")
	private Integer gkReflexes;
	@Column(name = "GKREACH")
	private Integer gkReach;
	
	@Column(name = "WEAKFOOTUSAGE")
	private Integer weakFootUsage;
	@Column(name = "WEAKFOOTACCURACY")
	private Integer weakFootAccuracy;
	@Column(name = "FORM")
	private Integer form;
	@Column(name = "INJURYRESISTANCE")
	private Integer injuryResistance;
	@Column(name = "RATING")
	private Integer rating;

}
