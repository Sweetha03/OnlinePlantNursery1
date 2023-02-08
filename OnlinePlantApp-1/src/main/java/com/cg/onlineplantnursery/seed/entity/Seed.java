package com.cg.onlineplantnursery.seed.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seedId;
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

	public Seed(String commonName, String bloomTime, String watering, String difficultyLevel, int minTemperature,
			int maxTemperature, String typeOfSeeds, String seedsDescription, int seedsStock, double seedsCost,
			int seedsPerPacket) {
		super();
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}

}
