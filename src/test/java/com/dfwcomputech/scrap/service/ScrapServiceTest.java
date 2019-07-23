package com.dfwcomputech.scrap.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ScrapServiceTest {
	
	public static final Integer MESSI=7511;
	public static final Integer NEYMAR=40352;
	
	@Autowired	
	private ScrapService scrapService;
		
	@Test
	public void whenScrapPlayer_thenPrint() {
		PlayerDetail detail = scrapService.scrapPlayer(MESSI);
		LoggerUtil.printPlayerDetail(detail);
	}
}
