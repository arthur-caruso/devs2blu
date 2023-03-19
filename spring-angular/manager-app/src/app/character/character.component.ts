import { Component, Input } from '@angular/core';

interface characterInterface {
	name: string,
	image: string,
	class: string,
	powers: string[],
	description: string
}

@Component({
	selector: 'app-character',
	templateUrl: './character.component.html',
	styleUrls: ['./character.component.css']
})
export class CharacterComponent {
	@Input() character: characterInterface;
	constructor() {
		this.character = {} as characterInterface;
	}
}
