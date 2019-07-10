package com.dfwcomputech.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.repository.PlayerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerRepositoryTest {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Test
	public void whenFindingPlayerById_thenCorrect() {
		Player testPlayer = new Player();
		testPlayer.setId(-1);
		testPlayer.setName("John Doe");
		
		playerRepository.save(testPlayer);
		assertThat(playerRepository.findById(-1)).isInstanceOf(Optional.class);
	}
	
}
