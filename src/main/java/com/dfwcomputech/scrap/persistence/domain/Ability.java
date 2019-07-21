package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table
public class Ability {	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playerId", nullable=false)
	private Player player;
	@Id
	private Integer level;

	private Integer attackingProwness;
	private Integer ballControl;
	private Integer dribbling;
	private Integer lowPass;
	private Integer loftedPass;
	private Integer finishing;
	private Integer placeKLicking;
	private Integer swerve;
	private Integer header;
	private Integer defensiveProwness;
	private Integer ballWinning;
	private Integer kickingPower;
	private Integer speed;
	private Integer explosivePower;
	private Integer unwaveringBalance;
	private Integer physicalContact;
	private Integer jump;
	private Integer goalkeeping;
	private Integer gkcatch;
	private Integer clearing;
	private Integer reflexes;
	private Integer coverage;
	private Integer stamina;
	private Integer weakFootUsage;
	private Integer weakFootAccuracy;
	private Integer form;
	private Integer injuryResistance;
	private Integer rating;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public Integer getPlaceKLicking() {
		return placeKLicking;
	}

	public void setPlaceKLicking(Integer placeKLicking) {
		this.placeKLicking = placeKLicking;
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
