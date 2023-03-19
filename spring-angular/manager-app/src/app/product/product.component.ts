import { Component, Input } from '@angular/core';

interface productInterface {
	name: string,
	price: number,
	description: string
}

@Component({
	selector: 'app-product',
	templateUrl: './product.component.html',
	styleUrls: ['./product.component.css']
})
export class ProductComponent {
	@Input() product: productInterface;
	constructor() {
		this.product = {} as productInterface;
	}
}
