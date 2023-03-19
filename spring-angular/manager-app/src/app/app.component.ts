import { Component } from '@angular/core';
import { HttpService } from './http.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css'],

})
export class AppComponent {
	title = "manager";

	// product test
	productObj = {
		name: "crowbar",
		price: 16.99,
		description: "a fine item"
	}

	// character test
	characterObj = {
		name: "chaves",
		image: "",
		class: "fighter",
		powers: ["zás", "zás", "zás"],
		description: "só não dá outra porque..."
	}

	constructor(private httpService: HttpService) { }
}