package com.dfwcomputech.scrap.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.Scout;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlayerServiceTest {

	public static final Integer MESSI=7511;
	public static final Integer NEYMAR=40352;
	
	@Autowired
	private PlayerService playerService;
	
	@Test
	public void whenScrapPlayer_thenPrint() {
		PlayerDetail detail = playerService.scrapPlayer(NEYMAR);
		LoggerUtil.printPlayerDetail(detail);
	}
	
	@Test
	public void whenSaveScout_thenPrint() {
		Scout scout = new Scout();
		Player player= new Player();
		player.setId(-46);
		
		scout.setPlayer(player);
		scout.setChance(100);
		scout.setLevel(5);
		scout.setScout1("PSG");
		scout.setScout2("LFW");
		scout.setScout2("PENALTY SPECIALIST");
		
		
		LoggerUtil.print(playerService.saveScout(scout));
		
	}
}
