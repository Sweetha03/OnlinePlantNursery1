package com.cg.onlineplantnursery.dto;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PlantAdminResponseDTO {
	
	private int plantId;
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
	
	private String msg;

}
