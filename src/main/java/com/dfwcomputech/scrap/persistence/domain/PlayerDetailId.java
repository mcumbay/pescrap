package com.dfwcomputech.scrap.persistence.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PlayerDetailId implements Serializable{

	private Integer patchId;
	private Integer playerId;
	
	
}
