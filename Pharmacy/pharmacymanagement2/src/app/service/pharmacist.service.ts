import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PharmacistModel } from '../model/pharmacist.model';

@Injectable({
  providedIn: 'root'
})
export class PharmacistService {
  baseUrl: string = "http://localhost:8087/api/pharmacist/"

  constructor(private httpClient: HttpClient) { }

  getAllPharmacist(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

  createpharmacist(pharmacist: PharmacistModel): Observable<any> {

    return this.httpClient.post(this.baseUrl + "save", pharmacist);
  }
}
