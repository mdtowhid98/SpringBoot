import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesMedicineService {

  baseUrl: string = "http://localhost:8087/api/salesmedicine/";

  constructor(private httpClient: HttpClient) { }

  getAllsalesMedicine(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }
}
