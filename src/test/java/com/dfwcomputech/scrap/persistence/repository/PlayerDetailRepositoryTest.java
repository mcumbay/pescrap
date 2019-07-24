package com.dfwcomputech.scrap.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.dfwcomputech.scrap.common.LoggerUtil;
import com.dfwcomputech.scrap.persistence.domain.Patch;
import com.dfwcomputech.scrap.persistence.domain.Player;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetailId;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlayerDetailRepositoryTest {
	
	@Autowired
	private PlayerDetailRepository playerDetailRepository;

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PatchRepository patchRepository;

	@Test
	@Rollback(false)
	public void whenCreatePlayerDetail_thenCorrect() {
		//C N'JIE (47427)
		PlayerDetail player =createTestPlayerDetail(47427);
		LoggerUtil.printPlayerDetail(player);
	}
	
	@Test
	public void whenExist_thenCorrect() {
		PlayerDetail player =createTestPlayerDetail(47427);
		assertThat(playerDetailRepository.exists(player.getId().getPatchId(), player.getId().getPlayerId()));
	}
	
	private PlayerDetail createTestPlayerDetail(Integer pesdbId) {
		Player player = playerRepository.findPlayerByPesdbId(pesdbId);
		Patch patch = patchRepository.findLatestPatch();
		
		PlayerDetail playerDetail = new PlayerDetail();
		playerDetail.setId(new PlayerDetailId(patch.getId(), player.getId()));
		playerDetail.setAge(30);
		playerDetail.setOprAtLevel30(79);
		playerDetail.setCurrentCondition("C");
		
		return playerDetailRepository.save(playerDetail);
	}

}
