package com.dfwcomputech.scrap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.service.SearchService;
import com.dfwcomputech.scrap.web.form.SearchPlayerForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@GetMapping
	public String prepareSearch(Model model) {
		log.info("Prepare Search");
		if(!model.containsAttribute("searchPlayerForm"))
			model.addAttribute("searchPlayerForm", new SearchPlayerForm());
		return "search";
	}

	@PostMapping
	public String searchPlayers(@Valid @ModelAttribute("searchPlayerForm") SearchPlayerForm searchPlayerForm,
			Errors errors, Model model) {

		log.info("Searching players");
		
	    if (errors.hasErrors()) 
	        return "search";
	   if(searchPlayerForm.getMinSpeed()==null)
		   searchPlayerForm.setMinSpeed(40);
	   if(searchPlayerForm.getMaxSpeed()==null)
		   searchPlayerForm.setMaxSpeed(99);
	    String speed = searchPlayerForm.getMinSpeed().toString()+"-"+searchPlayerForm.getMaxSpeed();
	    List<PesFilter> filters = new ArrayList<PesFilter>();
	    if(searchPlayerForm.getMinSpeed()!=40 && searchPlayerForm.getMaxSpeed()!=99)
			filters.add(new PesFilter("speed",speed));
	    
	    List<Player> results = searchService.search(filters);
	    if(results!=null)
	    	log.info("Number of results = {}", results.size());
	    else
	    	log.info("No results");
	    model.addAttribute("results", results);
		return "search";
	}

}
