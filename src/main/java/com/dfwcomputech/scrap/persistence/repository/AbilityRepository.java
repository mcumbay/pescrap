package com.dfwcomputech.scrap.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dfwcomputech.scrap.persistence.domain.Ability;
import com.dfwcomputech.scrap.persistence.domain.AbilityId;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, AbilityId> {

	public Boolean existsAbilityByIdPatchIdAndIdPlayerIdAndIdLevel(Integer patchId, Integer playerId, Integer level);

	public default Boolean exists(Integer patchId, Integer playerId, Integer level) {
		return existsAbilityByIdPatchIdAndIdPlayerIdAndIdLevel(patchId, playerId, level);
	}
}
