package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.PlayerDetail;
import com.dfwcomputech.scrap.persistence.domain.PlayerDetailId;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, PlayerDetailId>{

	public Boolean existsPlayerDetailByIdPatchIdAndIdPlayerId(Integer patchId, Integer playerId);
	
	public default Boolean exists(Integer patchId,Integer playerId) {
		return existsPlayerDetailByIdPatchIdAndIdPlayerId(patchId,playerId);
	} 
	
	@EntityGraph(attributePaths = {"team"})
	public PlayerDetail findByIdPatchIdAndIdPlayerId(Integer patchId,Integer playerId);
}
