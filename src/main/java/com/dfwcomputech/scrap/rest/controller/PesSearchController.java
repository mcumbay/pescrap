package com.dfwcomputech.scrap.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.service.ScrapService;
import com.dfwcomputech.scrap.service.SearchService;

@RestController
public class PesSearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	private ScrapService scrapService;
	
	@RequestMapping("/search")
	public List<Player> search(
			@RequestParam(value="speed", required = false)String speed,
			@RequestParam(value="overall_rating", required = false) String rating,
			@RequestParam(value="explosive_power", required=false) String acceleration,
			@RequestParam(value="form", required=false) String form){
		
		List<PesFilter> filters = new ArrayList<PesFilter>();
				
		if(speed!=null)
			filters.add(new PesFilter("speed",speed));
		if(rating!=null)
			filters.add(new PesFilter("overall_rating",rating));
		if(form!=null)
			filters.add(new PesFilter("form",form));
		if(acceleration!=null)
			filters.add(new PesFilter("explosive_power",acceleration));
		
		return searchService.search(filters);
	}
	
	@RequestMapping("/scrap")
	public Player scrapPlayer(@RequestParam(value="id", required = false)String pesdbId) {
		Integer id = Integer.valueOf(pesdbId);
		return scrapService.scrapPlayer(id);
	}
	
}
