import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from 'src/environments/environment.development';

@Injectable({ providedIn: 'root' })
export class EmployeeService {
	private apiServerUrl = environment.apiBaseUrl;

	constructor(private http: HttpClient) { }

	public getEmployees(): Observable<Employee[]> {
		return this.http.get<Employee[]>(`${this.apiServerUrl}/Employee/getAll`);
	}

	public addEmployee(employee: Employee): Observable<Employee> {
		return this.http.post<Employee>(`${this.apiServerUrl}/Employee/create`, employee);
	}

	public updateEmployee(employee: Employee): Observable<Employee> {
		return this.http.put<Employee>(`${this.apiServerUrl}/Employee/update`, employee);
	}

	public deleteEmployee(id: number | undefined): Observable<void> {
		return this.http.delete<void>(`${this.apiServerUrl}/Employee/delete/${id}`);
	}
}