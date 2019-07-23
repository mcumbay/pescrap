package com.dfwcomputech.scrap.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlayingStyleRepositoryTest {
	
	@Autowired
	private PlayingStyleRepository playingStyleRepository;
	
	@Test
	public void whenFindByStyle_thenPrint() {
		LoggerUtil.print(playingStyleRepository.findByStyle("The Destroyer"));
	}

}
