package com.dfwcomputech.scrap.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.service.PlayerService;
import com.dfwcomputech.scrap.service.ScrapService;
import com.dfwcomputech.scrap.web.form.SearchForm;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private ScrapService scrapService;
	
	@Autowired
	private PlayerService playerService;
	
	
	  @RequestMapping(method=GET)
	  public String prepareHome() {
		  System.out.println("Init Home");
	    return "home";	
	  }
	  
	  @RequestMapping(method=POST)	
	  public String submit(SearchForm searchForm) {
		  System.out.println("Scrapping player with id "+searchForm.getId());
		  Integer pesdbId= Integer.valueOf(searchForm.getId());
		  Player player = scrapService.scrapPlayer(pesdbId);
	    return "redirect:/pescrap/"+player.getPesdbId();	
	  }
	  
	  @RequestMapping(value="/{id}", method=GET)
	  public String showSpitterProfile(
	        @PathVariable String id, Model model) {
		 Integer pesdbId= Integer.valueOf(id);
	    Player player = playerService.findPlayerByPesdbId(pesdbId);
	    model.addAttribute(player);
	    return "player";
	  }
}
