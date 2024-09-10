import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineGenericModel } from '../model/medicineGeneric.model';

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


}
