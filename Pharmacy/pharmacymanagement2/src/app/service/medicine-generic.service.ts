import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { MedicineGenericModel } from '../model/medicineGeneric.model';
import { error } from 'console';

@Injectable({
  providedIn: 'root'
})
export class MedicineGenericService {

  baseUrl: string = "http://localhost:8087/api/medicinegeneric/"

  constructor(private httpClient: HttpClient) { }

  getAllMedicineGeneric(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

  createMedicineGeneric(generic: MedicineGenericModel): Observable<any> {

    return this.httpClient.post(this.baseUrl + "save", generic);
  }

  deleteMedicineGeneric(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}delete/${id}`);
  }

  // updateMedicineGeneric(id: number, generic: MedicineGenericModel): Observable<any> {
  //   return this.httpClient.put(`${this.baseUrl}update/${id}`, generic);
  // }
  updateMedicineGeneric(id: number, generic: MedicineGenericModel): Observable<any> {
    return this.httpClient.put(this.baseUrl+"update/"+id, generic); // Corrected with comma
  }
  

  
  getById(id:number):Observable<any>{

    return this.httpClient.get(this.baseUrl+id);
  }



}