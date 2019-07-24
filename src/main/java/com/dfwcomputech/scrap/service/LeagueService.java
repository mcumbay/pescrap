package com.dfwcomputech.scrap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfwcomputech.scrap.persistence.domain.League;
import com.dfwcomputech.scrap.persistence.domain.Team;
import com.dfwcomputech.scrap.persistence.repository.LeagueRepository;
import com.dfwcomputech.scrap.persistence.repository.TeamRepository;

@Service
public class LeagueService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private LeagueRepository leagueRepository;
	
	public Team getTeam(String teamName,String leagueName) {
		if(teamName!=null && !teamName.isBlank()) {
			Team team = teamRepository.findByTeamName(teamName);
			if(team==null) {
				League league = leagueRepository.findByLeagueName(leagueName);				
				team= new Team();
				team.setName(teamName);
				team.setLeague(league);
				return teamRepository.save(team);
			}
				
		}
		return null;
	}
}
