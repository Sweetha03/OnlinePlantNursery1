package com.cg.plantnursery.seed.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeedDTO {

	private int id;
	private String commonName;
	private String bloomTime;
	private String watering;
	private String difficultyLevel;
	private int minTemperature;
	private int maxTemperature;
	private String typeOfSeeds;
	private String seedsDescription;
	private int seedsStock;
	private double seedsCost;
	private int seedsPerPacket;
}
