package com.cg.onlineplantnursery.util;

import org.springframework.stereotype.Component;



import com.cg.onlineplantnursery.dto.PlantAdminResponseDTO;
import com.cg.onlineplantnursery.dto.PlantDTO;
import com.cg.onlineplantnursery.entity.Plant;
@Component

public class PlantDTOConvertor {
	
	public PlantAdminResponseDTO getPlantAdminResponseDTO(Plant plant) 
	{
	
	PlantAdminResponseDTO dto = new PlantAdminResponseDTO();
	dto.setPlantId(plant.getPlantId());
	dto.setPlantHeight(plant.getPlantHeight());
	dto.setPlantSpread(plant.getPlantSpread());
	dto.setCommonName(plant.getCommonName());
	dto.setBloomTime(plant.getBloomTime());
	dto.setMedicinal(plant.getMedicinal());
	dto.setMinTemparature(plant.getMinTemparature());
	dto.setMaxTemperature(plant.getMaxTemperature());
	dto.setTypeOfPlant(plant.getTypeOfPlant());
	dto.setPlantDescription(plant.getPlantDescription());
	dto.setPlantsStock(plant.getPlantsStock());
	dto.setPlantCost(plant.getPlantCost());
	         return dto;
     }
public PlantDTO getPlantDTO(Plant p) {
	
   PlantDTO obj = new PlantDTO(p.getPlantId(),p.getPlantHeight(),p.getPlantSpread(),p.getCommonName(),p.getBloomTime(),p.getMedicinal(),p.getMinTemparature(),p.getMaxTemperature(),p.getTypeOfPlant(),p.getPlantDescription(),p.getPlantsStock(),p.getPlantCost());
         return obj;
}


}
