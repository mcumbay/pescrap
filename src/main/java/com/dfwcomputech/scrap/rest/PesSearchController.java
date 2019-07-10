package com.dfwcomputech.scrap.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dfwcomputech.scrap.common.PesFilter;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.service.SearchService;

@RestController
public class PesSearchController {
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	public List<Player> search(@RequestParam(value="speed", required=false)String speed){
		
		PesFilter filter = new PesFilter("speed",speed);		
		return searchService.search(Arrays.asList(filter));
	}
}
