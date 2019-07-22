package com.dfwcomputech.scrap.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;
import com.dfwcomputech.scrap.persistence.domain.Player;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlayerRepositoryTest {
		
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PlayerRepository playerRepository;

	@Test
	public void whenFindAllPlayers_thenPrint() {		
		LoggerUtil.printPlayerList(playerRepository.findAll());
	}
	
	@Test
	public void whenExistsByPesdbId_thenCorrect(){
		Player player = new Player();
		player.setPesdbId(-1);
		player.setName("John Doe");
		player.setNationality("Peruvian");
		
		entityManager.persist(player);
		
		assertThat(playerRepository.existsPlayerByPesdbId(-1));
			
	}
	
}
