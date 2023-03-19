import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';

import { Pet } from './pet';
import { PetService } from './pet.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
	title = 'petshop';

	public pets: Pet[] = [];
	public editPet: Pet | null = null;
	public deletePet: Pet | null = null;

	constructor(private petService: PetService) { }

	ngOnInit(): void {
		this.getPets();
	}

	public getPets(): void {
		this.petService.getPets().subscribe(
			(response: Pet[]) => { this.pets = response },
			(error: HttpErrorResponse) => { alert(error.message) });
	}

	public onAddPet(addForm: NgForm): void {
		document.getElementById('add-pet-form')?.click();

		this.petService.addPet(addForm.value).subscribe(
			(response: Pet) => {
				this.getPets();
				addForm.reset();
			},
			(error: HttpErrorResponse) => { alert(error.message) });
	}

	public onUpdatePet(pet: Pet): void {
		this.petService.updatePet(pet).subscribe(
			(response: Pet) => { this.getPets(); },
			(error: HttpErrorResponse) => { alert(error.message) })
		this.editPet = null;
	}

	public onDeletePet(id: string | undefined): void {
		this.petService.deletePet(id).subscribe(
			(response: void) => { this.getPets() },
			(error: HttpErrorResponse) => { alert(error.message) })
		this.deletePet = null;
	}

	public searchPets(key: string): void {
		const results: Pet[] = [];
		for (const pet of this.pets) {
			if (pet.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.species.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.race.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.height.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.weight.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.furType.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				pet.treatmentType.toLowerCase().indexOf(key.toLowerCase()) !== -1)

				results.push(pet);
		}
		this.pets = results;
		if (results.length === 0 || !key)
			this.getPets();
	}

	public onOpenModal(pet: Pet | null, mode: string): void {
		const container = document.getElementById('main-container')
		const button = document.createElement('button');
		button.type = 'button';
		button.style.display = 'none';
		button.setAttribute('data-toggle', 'modal');

		button.setAttribute('data-target', `#${mode}PetModal`)

		if (mode === 'update')
			this.editPet = pet;

		if (mode === 'delete')
			this.deletePet = pet;

		container?.appendChild(button);
		button.click();
	}

}