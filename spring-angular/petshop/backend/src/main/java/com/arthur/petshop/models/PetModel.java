package com.arthur.petshop.models;

import java.io.Serializable;
import java.util.UUID;

import com.arthur.petshop.enums.FurEnum;
import com.arthur.petshop.enums.TreatmentEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_PET")
public class PetModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String species;

	@Column(nullable = false)
	private String race;

	@Column(nullable = false)
	private double height;

	@Column(nullable = false)
	private double weight;

	@Column(nullable = false)
	private FurEnum furType;

	@Column(nullable = false)
	private TreatmentEnum treatmentType;
}