package com.dfwcomputech.scrap.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "PLAYER")
@Data
public class Player {
	@Id
	@GeneratedValue(generator = "PLAYER_ID_GENERATOR")
	@SequenceGenerator(name = "PLAYER_ID_GENERATOR", sequenceName = "PLAYER_SEQUENCE",allocationSize=1)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PESDBID")
	private Integer pesdbId;
	
	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "NATIONALITYID")
	private Nationality nationality;
	
}
