package com.cg.onlineplantnursery.seed.util;

import org.springframework.stereotype.Component;

import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.plantnursery.seed.DTO.SeedAdminResponseDTO;
import com.cg.plantnursery.seed.DTO.SeedDTO;

@Component
public class SeedDTOConvertor {

	public SeedAdminResponseDTO getSeedAdminResponseDTO(Seed seed) {

		SeedAdminResponseDTO dto = new SeedAdminResponseDTO();
		dto.setSId(seed.getSeedId());
		dto.setCommonName(seed.getCommonName());
		dto.setBloomTime(seed.getBloomTime());
		dto.setWatering(seed.getWatering());
		dto.setDifficultyLevel(seed.getDifficultyLevel());
		dto.setMinTemperature(seed.getMinTemperature());
		dto.setMaxTemperature(seed.getMaxTemperature());
		dto.setTypeOfSeeds(seed.getTypeOfSeeds());
		dto.setSeedsDescription(seed.getSeedsDescription());
		dto.setSeedsStock(seed.getSeedsStock());
		dto.setSeedsCost(seed.getSeedsCost());
		dto.setSeedsPerPacket(seed.getSeedsPerPacket());
		dto.setMsg("Seed saved");
		return dto;
	}

	public SeedDTO getSeedDTO(Seed s) {

		SeedDTO obj = new SeedDTO(s.getSeedId(), s.getCommonName(), s.getBloomTime(), s.getWatering(),
				s.getDifficultyLevel(), s.getMinTemperature(), s.getMaxTemperature(), s.getTypeOfSeeds(),
				s.getSeedsDescription(), s.getSeedsStock(), s.getSeedsCost(), s.getSeedsPerPacket());
		return obj;
	}

}
