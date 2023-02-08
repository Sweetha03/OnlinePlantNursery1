package com.cg.onlineplantnursery.dto;

import java.util.List;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlantDTO {
	
	private int id;
	private int plantHeight;
	private String plantSpread; 
	private String commonName; 
	private String bloomTime;
	private String medicinal;
	private int minTemparature;
	private int maxTemperature;
	private String typeOfPlant;
	private String plantDescription;
	private int plantsStock;
	private double plantCost;

}
