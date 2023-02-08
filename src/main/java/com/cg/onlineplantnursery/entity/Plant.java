package com.cg.onlineplantnursery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Plant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public Plant(int plantHeight, String plantSpread, String commonName, String bloomTime, String medicinal,
			int minTemparature, int maxTemperature, String typeOfPlant, String plantDescription, int plantsStock,
			double plantCost) {
		super();
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinal = medicinal;
		this.minTemparature = minTemparature;
		this.maxTemperature = maxTemperature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		this.plantCost = plantCost;
	}
	

}
