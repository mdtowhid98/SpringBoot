import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PatientModel } from '../model/patientModel';

@Injectable({
  providedIn: 'root'
})
export class PatientService {
baseUrl:string="http://localhost:8087/api/reg/"

  constructor(private httpClient:HttpClient) { }

  getAllRegisterPatient(): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl);
  }
 
  createPatient(reg:PatientModel):Observable<any>{

    return this.httpClient.post(this.baseUrl+"save",reg);
   }


   deletePatient(id: number): Observable<any> {

    return this.httpClient.delete(this.baseUrl+ "delete/"+ id);
  }

  updatePatient(id: number, reg: PatientModel): Observable<any> {
    return this.httpClient.put<any>(this.baseUrl + "update/" + id, reg); 
  }

  getById(id: number): Observable<any> {

    return this.httpClient.get(this.baseUrl + id);
  }
}
