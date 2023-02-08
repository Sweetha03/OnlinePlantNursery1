package com.cg.onlineplantnursery.seed.controller;

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

import com.cg.onlineplantnursery.exception.SeedIdNotFoundException;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.SeedServiceImpl;
import com.cg.onlineplantnursery.seed.util.SeedDTOConvertor;
import com.cg.plantnursery.seed.DTO.SeedAdminResponseDTO;

@RestController
@RequestMapping("/seed")
public class SeedController {

	@Autowired
	private SeedServiceImpl seedService; 

	@Autowired
	SeedDTOConvertor seedDTO;

	@PostMapping("/add")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed)  {
		Seed newSeed = seedService.addSeed(seed);
		SeedAdminResponseDTO responseDTO = seedDTO.getSeedAdminResponseDTO(newSeed);

		return new ResponseEntity<Seed>(newSeed, HttpStatus.OK);
	}

	@PutMapping("/updateseed/{seedId}")
	public String updatedOrder(@PathVariable int seedId) throws SeedIdNotFoundException  {
		Seed updatedSeed = seedService.viewSeed(seedId);
		return updatedSeed.toString();
	}

	@DeleteMapping("/delete/{seedid}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Seed seedId) throws SeedIdNotFoundException {
		if (seedId == null) {
			throw new SeedIdNotFoundException("No seed found");
		} else {
			Seed deletedSeed = seedService.deleteSeed(seedId);
			return new ResponseEntity<Seed>(deletedSeed, HttpStatus.OK);
		}
	}

	@GetMapping("/view/{sId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable Integer sId) throws SeedIdNotFoundException {
		if (sId == null) {
			throw new SeedIdNotFoundException("Seed Id Not Found");
		} else {
			Seed viewSeed = seedService.viewSeed(sId);
			return new ResponseEntity<Seed>(viewSeed, HttpStatus.OK);
		}
	}

	@GetMapping("/showseeds/{seedid}")
	public ResponseEntity<List<Seed>> getAllSeeds() throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getAllSeeds();

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);

	}

	@GetMapping("/getseeds/{name}")
	public ResponseEntity<List<Seed>> getSeedByName(@PathVariable String Name) throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getSeedByCommonName(Name);

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);

	}

	@GetMapping("/showseedslist/{typeofseeds}")
	public ResponseEntity<List<Seed>> getPlantByTypeOfSeeds(@PathVariable String typeOfSeeds)
			throws SeedIdNotFoundException {
		List<Seed> seeds = this.seedService.getPlantByTypeOfSeeds(typeOfSeeds);

		return new ResponseEntity<List<Seed>>(seeds, HttpStatus.OK);
	}

}
