package com.dfwcomputech.scrap.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.domain.Ability;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping(value="/{id}")
	  public String preparePlayerPage(
	        @PathVariable Integer id, Model model) {
		log.info("Preparing Player Details for id={}",id);
		//Integer id= Integer.valueOf(id);
	    Player player = playerService.findPlayerById(id);
	    PlayerDetail playerDetail = playerService.findCurrentDetails(id);
	    model.addAttribute("player",player);
	    model.addAttribute("playerDetail",playerDetail);
	    return "player";
	  }
	
	@GetMapping(value="/{id}/abilities")
	public  String prepareAbilities(@PathVariable Integer id, Model model) {
		log.info("Preparing Player Abilities for id={}",id);
		Ability ability = playerService.findAbilitiesByLevel(id,1);
		model.addAttribute("ability",ability);
		return "abilities";
	}
}
