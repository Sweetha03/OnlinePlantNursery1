package com.cg.onlineplantnursery.controller;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.dto.PlantAdminResponseDTO;
import com.cg.onlineplantnursery.dto.PlantDTO;
import com.cg.onlineplantnursery.exceptions.PlantIdNotFoundException;
import com.cg.onlineplantnursery.entity.Plant;
import com.cg.onlineplantnursery.service.IPlantService;
import com.cg.onlineplantnursery.util.PlantDTOConvertor;






@RestController
@RequestMapping("/plant")

public class PlantController {
	@Autowired
	IPlantService plantService;
	
	@Autowired
	PlantDTOConvertor plantDTOConvertor;
	
	@PostMapping("/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) throws PlantIdNotFoundException
	{
		//Plant newPlant = plantService.addPlant(plant);
		//PlantAdminResponseDTO responseDTO = plantService.getPlantAdminResponseDTO(newPlant);

		if(plant == null) {
			throw new PlantIdNotFoundException("Plant ID Not Found");
			
		}
		else {
			Plant addPlant = plantService.addPlant(plant);
		}
		
		
		return new ResponseEntity<Plant>(plant, HttpStatus.OK);
	}
	
	@PutMapping("/updatePlant/{plantId}")
	public String updatedPlant(@PathVariable int plantId) throws PlantIdNotFoundException 
	{
		Plant updatedPlant = plantService.viewPlant(plantId);
	return updatedPlant.toString();
	}
	
	@DeleteMapping("/delete/{plant}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Plant plant) throws PlantIdNotFoundException
	{
		if(plant == null) {
			throw new PlantIdNotFoundException("No plant found");
		}
		else {
			Plant deletedPlant = plantService.deletePlant(plant);
			return new ResponseEntity<Plant>(deletedPlant, HttpStatus.OK);
		}
	}
	
	@GetMapping("/plant/view/{pId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer plantId) throws PlantIdNotFoundException
	{
		if(plantId == null) {
			throw new PlantIdNotFoundException("Plant Id Not Found");
		}
		else {
			Plant viewPlant = plantService.viewPlant(plantId);
			return new ResponseEntity<Plant>(viewPlant, HttpStatus.OK);
		}
	}
	
	@GetMapping("/showplants")
	public ResponseEntity<List<Plant>>getviewAllPlants()throws PlantIdNotFoundException
	{
		List<Plant> plants = this.plantService.viewAllPlants();
		
		return new ResponseEntity<List<Plant>>(plants, HttpStatus.OK);
		
	}
	@GetMapping("/getplants/{name}")
	public ResponseEntity<List<Plant>> getPlantByName(@PathVariable  String Name)throws PlantIdNotFoundException
	{
		List<Plant> plants = this.plantService.viewPlant(Name);
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
		
	}
	
	@GetMapping("/showplantsList/{type}")
	public ResponseEntity<List<Plant>> getPlantByTypeOfPlants(@PathVariable String type) throws PlantIdNotFoundException
	{
		List<Plant> plants = this.plantService.viewPlant(type);
		
		return new ResponseEntity<List<Plant>>(plants,HttpStatus.OK);
	}
	
}
