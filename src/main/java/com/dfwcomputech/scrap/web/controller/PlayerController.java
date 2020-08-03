package com.dfwcomputech.scrap.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.domain.Player;

@Controller
@RequestMapping("/players")
public class PlayerController {

	@GetMapping("/current")
	public String preparePlayerPage(Model model) {
		model.addAttribute("player",new Player());
		return "player";
	}
}
