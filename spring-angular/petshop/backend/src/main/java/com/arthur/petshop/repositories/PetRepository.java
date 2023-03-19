package com.arthur.petshop.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthur.petshop.models.PetModel;

@Repository
public interface PetRepository extends JpaRepository<PetModel, UUID> {
	public Optional<PetModel> findById(UUID id);

	public void deleteById(UUID id);
}
