package com.dfwcomputech.scrap.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.service.ScrapService;
import com.dfwcomputech.scrap.web.form.SearchForm;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/scrap")
public class ScrapController {
	
	@Autowired
	private ScrapService scrapService;
		
	  @GetMapping
	  public String prepareHome(Model model) {
		  log.info("Preparing Scrap");
		  model.addAttribute("searchForm", new SearchForm());
	    return "scrap";	
	  }
	  
	  @PostMapping
	  public String scrapPlayer(@Valid @ModelAttribute("searchForm")SearchForm searchForm,
			  Errors errors, Model model) {
		  log.info("Scrapping player with id ={} ",searchForm.getId());
		    if (errors.hasErrors()) {
		        return "scrap";
		      }
		  Integer pesdbId= Integer.valueOf(searchForm.getId());
		  Player player = scrapService.scrapPlayer(pesdbId);
	    return "redirect:/players/"+player.getPesdbId();	
	  }
	  

}
