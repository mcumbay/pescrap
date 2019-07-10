package com.dfwcomputech.scrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public void save(Player player) {
		//Verify if there are player information
		if(player!=null) {
			//Verify if the Id was provided
			if(player.getId()!=null) {
				//Verify if the id already exist on DB
				if(!playerRepository.existsById(player.getId())) {
					playerRepository.save(player);
				}else {
					System.out.println("Player with Id="+player.getId()+" already exists.");
				}
					
			}
		}
	}
}
