package com.arthur.petshop.controllers;

import java.util.List;
import java.util.UUID;

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

import com.arthur.petshop.models.PetModel;
import com.arthur.petshop.services.PetService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/Pet")
public class PetController {
	@Autowired
	private PetService petService;

	@GetMapping("/getAll")
	public ResponseEntity<List<PetModel>> getAllPets() {
		List<PetModel> pets = petService.findAll();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<PetModel> findPetById(@PathVariable("id") UUID id) {
		PetModel petModel = petService.findById(id);
		return new ResponseEntity<>(petModel, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<PetModel> createPet(@RequestBody PetModel petModel) {
		PetModel newPetModel = petService.create(petModel);
		return new ResponseEntity<>(newPetModel, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<PetModel> updatePet(@RequestBody PetModel petModel) {
		PetModel newPetModel = petService.update(petModel);
		return new ResponseEntity<>(newPetModel, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePetById(@PathVariable("id") UUID id) {
		petService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
