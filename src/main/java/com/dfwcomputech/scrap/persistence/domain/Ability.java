package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ABILITY_LEVEL")
public class Ability {

	@EmbeddedId
	private AbilityId id;

	@Column(name = "ATTACKINGPROWNESS")
	private Integer attackingProwness;
	@Column(name = "BALLCONTROL")
	private Integer ballControl;
	@Column(name = "DRIBBLING")
	private Integer dribbling;
	@Column(name = "LOWPASS")
	private Integer lowPass;
	@Column(name = "LOFTEDPASS")
	private Integer loftedPass;
	@Column(name = "FINISHING")
	private Integer finishing;
	@Column(name = "PLACEKICKING")
	private Integer placeKicking;
	@Column(name = "SWERVE")
	private Integer swerve;
	@Column(name = "HEADER")
	private Integer header;
	@Column(name = "DEFENSIVEPROWNESS")
	private Integer defensiveProwness;
	@Column(name = "BALLWINNING")
	private Integer ballWinning;
	@Column(name = "KICKINGPOWER")
	private Integer kickingPower;
	@Column(name = "SPEED")
	private Integer speed;
	@Column(name = "EXPLOSIVEPOWER")
	private Integer explosivePower;
	@Column(name = "UNWAVERINGBALANCE")
	private Integer unwaveringBalance;
	@Column(name = "PHYSICALCONTACT")
	private Integer physicalContact;
	@Column(name = "JUMP")
	private Integer jump;
	@Column(name = "GOALKEEPING")
	private Integer goalkeeping;
	@Column(name = "GKCATCH")
	private Integer gkcatch;
	@Column(name = "CLEARING")
	private Integer clearing;
	@Column(name = "REFLEXES")
	private Integer reflexes;
	@Column(name = "COVERAGE")
	private Integer coverage;
	@Column(name = "STAMINA")
	private Integer stamina;
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

	public AbilityId getId() {
		return id;
	}

	public void setId(AbilityId id) {
		this.id = id;
	}

	public Integer getAttackingProwness() {
		return attackingProwness;
	}

	public void setAttackingProwness(Integer attackingProwness) {
		this.attackingProwness = attackingProwness;
	}

	public Integer getBallControl() {
		return ballControl;
	}

	public void setBallControl(Integer ballControl) {
		this.ballControl = ballControl;
	}

	public Integer getDribbling() {
		return dribbling;
	}

	public void setDribbling(Integer dribbling) {
		this.dribbling = dribbling;
	}

	public Integer getLowPass() {
		return lowPass;
	}

	public void setLowPass(Integer lowPass) {
		this.lowPass = lowPass;
	}

	public Integer getLoftedPass() {
		return loftedPass;
	}

	public void setLoftedPass(Integer loftedPass) {
		this.loftedPass = loftedPass;
	}

	public Integer getFinishing() {
		return finishing;
	}

	public void setFinishing(Integer finishing) {
		this.finishing = finishing;
	}

	public Integer getPlaceKicking() {
		return placeKicking;
	}

	public void setPlaceKicking(Integer placeKicking) {
		this.placeKicking = placeKicking;
	}

	public Integer getSwerve() {
		return swerve;
	}

	public void setSwerve(Integer swerve) {
		this.swerve = swerve;
	}

	public Integer getHeader() {
		return header;
	}

	public void setHeader(Integer header) {
		this.header = header;
	}

	public Integer getDefensiveProwness() {
		return defensiveProwness;
	}

	public void setDefensiveProwness(Integer defensiveProwness) {
		this.defensiveProwness = defensiveProwness;
	}

	public Integer getBallWinning() {
		return ballWinning;
	}

	public void setBallWinning(Integer ballWinning) {
		this.ballWinning = ballWinning;
	}

	public Integer getKickingPower() {
		return kickingPower;
	}

	public void setKickingPower(Integer kickingPower) {
		this.kickingPower = kickingPower;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getExplosivePower() {
		return explosivePower;
	}

	public void setExplosivePower(Integer explosivePower) {
		this.explosivePower = explosivePower;
	}

	public Integer getUnwaveringBalance() {
		return unwaveringBalance;
	}

	public void setUnwaveringBalance(Integer unwaveringBalance) {
		this.unwaveringBalance = unwaveringBalance;
	}

	public Integer getPhysicalContact() {
		return physicalContact;
	}

	public void setPhysicalContact(Integer physicalContact) {
		this.physicalContact = physicalContact;
	}

	public Integer getJump() {
		return jump;
	}

	public void setJump(Integer jump) {
		this.jump = jump;
	}

	public Integer getGoalkeeping() {
		return goalkeeping;
	}

	public void setGoalkeeping(Integer goalkeeping) {
		this.goalkeeping = goalkeeping;
	}

	public Integer getGkcatch() {
		return gkcatch;
	}

	public void setGkcatch(Integer gkcatch) {
		this.gkcatch = gkcatch;
	}

	public Integer getClearing() {
		return clearing;
	}

	public void setClearing(Integer clearing) {
		this.clearing = clearing;
	}

	public Integer getReflexes() {
		return reflexes;
	}

	public void setReflexes(Integer reflexes) {
		this.reflexes = reflexes;
	}

	public Integer getCoverage() {
		return coverage;
	}

	public void setCoverage(Integer coverage) {
		this.coverage = coverage;
	}

	public Integer getStamina() {
		return stamina;
	}

	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}

	public Integer getWeakFootUsage() {
		return weakFootUsage;
	}

	public void setWeakFootUsage(Integer weakFootUsage) {
		this.weakFootUsage = weakFootUsage;
	}

	public Integer getWeakFootAccuracy() {
		return weakFootAccuracy;
	}

	public void setWeakFootAccuracy(Integer weakFootAccuracy) {
		this.weakFootAccuracy = weakFootAccuracy;
	}

	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public Integer getInjuryResistance() {
		return injuryResistance;
	}

	public void setInjuryResistance(Integer injuryResistance) {
		this.injuryResistance = injuryResistance;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
