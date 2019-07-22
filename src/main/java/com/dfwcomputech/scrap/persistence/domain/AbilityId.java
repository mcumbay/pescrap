package com.dfwcomputech.scrap.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AbilityId implements Serializable{
	private static final long serialVersionUID = -209224791883271038L;
	@Column(name = "PATCHID")
	private Integer patchId;
	@Column(name = "PLAYERID")
	private Integer playerId;
	@Column(name = "LEVEL")
	private Integer level;

	protected AbilityId() {
	}

	public AbilityId(Integer patchId, Integer playerId, Integer level) {		
		this.patchId = patchId;
		this.playerId = playerId;
		this.level = level;
	}

	public Integer getPatchId() {
		return patchId;
	}

	public void setPatchId(Integer patchId) {
		this.patchId = patchId;
	}

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
