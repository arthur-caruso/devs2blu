import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';

import { Employee } from './employee';
import { EmployeeService } from './employee.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

	public employees: Employee[] = [];
	public editEmployee: Employee | null = null;
	public deleteEmployee: Employee | null = null;

	constructor(private employeeService: EmployeeService) { }

	ngOnInit(): void {
		this.getEmployees();
	}

	public getEmployees(): void {
		this.employeeService.getEmployees().subscribe(
			(response: Employee[]) => { this.employees = response },
			(error: HttpErrorResponse) => { alert(error.message) });
	}

	public onAddEmployee(addForm: NgForm): void {
		document.getElementById('add-employee-form')?.click();

		this.employeeService.addEmployee(addForm.value).subscribe(
			(response: Employee) => {
				this.getEmployees();
				addForm.reset();
			},
			(error: HttpErrorResponse) => { alert(error.message) });
	}

	public onUpdateEmployee(employee: Employee): void {
		this.employeeService.updateEmployee(employee).subscribe(
			(response: Employee) => { this.getEmployees(); },
			(error: HttpErrorResponse) => { alert(error.message) })
		this.editEmployee = null;
	}

	public onDeleteEmployee(id: number | undefined): void {
		this.employeeService.deleteEmployee(id).subscribe(
			(response: void) => { this.getEmployees() },
			(error: HttpErrorResponse) => { alert(error.message) })
		this.deleteEmployee = null;
	}

	public searchEmployees(key: string): void {
		const results: Employee[] = [];
		for (const employee of this.employees) {
			if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1 ||
				employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1)
				results.push(employee);
		}
		this.employees = results;
		if (results.length === 0 || !key)
			this.getEmployees();
	}

	public onOpenModal(employee: Employee | null, mode: string): void {
		const container = document.getElementById('main-container')
		const button = document.createElement('button');
		button.type = 'button';
		button.style.display = 'none';
		button.setAttribute('data-toggle', 'modal');

		button.setAttribute('data-target', `#${mode}EmployeeModal`)

		if (mode === 'update')
			this.editEmployee = employee;

		if (mode === 'delete')
			this.deleteEmployee = employee;

		container?.appendChild(button);
		button.click();
	}

}