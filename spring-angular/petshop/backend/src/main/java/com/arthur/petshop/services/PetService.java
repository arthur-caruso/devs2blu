package com.arthur.petshop.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthur.petshop.exceptions.ItemNotFoundException;
import com.arthur.petshop.models.PetModel;
import com.arthur.petshop.repositories.PetRepository;

@Service
public class PetService {
	@Autowired
	private PetRepository petRepository;

	public PetModel create(PetModel petModel) {
		petModel.setId(UUID.randomUUID());
		return petRepository.save(petModel);
	}

	public List<PetModel> findAll() {
		return petRepository.findAll();
	}

	public PetModel findById(UUID id) {
		String message = "Item by id " + id.toString() + " was not found.";
		return petRepository.findById(id).orElseThrow(
				() -> new ItemNotFoundException(message));
	}

	public PetModel update(PetModel petModel) {
		return petRepository.save(petModel);
	}

	public void deleteById(UUID id) {
		petRepository.deleteById(id);
	}
}