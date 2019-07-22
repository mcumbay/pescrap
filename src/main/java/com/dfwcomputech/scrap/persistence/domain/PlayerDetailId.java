package com.dfwcomputech.scrap.persistence.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlayerDetailId implements Serializable{

	private static final long serialVersionUID = -302315157982635844L;
	
	@Column(name="PATCHID")
	private Integer patchId;
	@Column(name="PLAYERID")
	private Integer playerId;
		
	protected PlayerDetailId() {
	}
	public PlayerDetailId(Integer patchId, Integer playerId) {
		super();
		this.patchId = patchId;
		this.playerId = playerId;
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
	
	
}
