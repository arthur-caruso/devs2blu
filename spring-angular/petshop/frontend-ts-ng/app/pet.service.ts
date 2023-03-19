import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pet } from './pet';
import { environment } from 'src/environments/environment.development';

@Injectable({ providedIn: 'root' })
export class PetService {
	private apiServerUrl = environment.apiBaseUrl;

	constructor(private http: HttpClient) { }

	public getPets(): Observable<Pet[]> {
		return this.http.get<Pet[]>(`${this.apiServerUrl}/Pet/getAll`);
	}

	public addPet(pet: Pet): Observable<Pet> {
		return this.http.post<Pet>(`${this.apiServerUrl}/Pet/create`, pet);
	}

	public updatePet(pet: Pet): Observable<Pet> {
		return this.http.put<Pet>(`${this.apiServerUrl}/Pet/update`, pet);
	}

	public deletePet(id: string | undefined): Observable<void> {
		return this.http.delete<void>(`${this.apiServerUrl}/Pet/delete/${id}`);
	}
}