package com.dfwcomputech.scrap.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.domain.Player;
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
	        @PathVariable String id, Model model) {
		log.info("Preparing page for pesId ={}",id);
		 Integer pesdbId= Integer.valueOf(id);
	    Player player = playerService.findPlayerByPesdbId(pesdbId);
	    model.addAttribute("player",player);
	    return "player";
	  }
}
