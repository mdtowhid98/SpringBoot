import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedicineModel } from '../model/medicine.model';
import { ApiResponse } from '../util/api.response.model';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  baseUrl: string = "http://localhost:8087/api/medicine/"


  constructor(private httpClient: HttpClient) { }


  getAllMedicine(): Observable<ApiResponse> {
    return this.httpClient.get<ApiResponse>(this.baseUrl);
  }

  // createMedicine(medicine:MedicineModel):Observable<MedicineModel>{

  //   return this.httpClient.post<MedicineModel>(this.baseUrl+"save",medicine);
  // }


 


  createMedicine(medicine: MedicineModel, image: File): Observable<ApiResponse> {

    const formData = new FormData();

    formData.append('medicine', new Blob([JSON.stringify(medicine)], { type: 'application/json' }));

    // Append image file
    formData.append('image', image);

    return this.httpClient.post<ApiResponse>(this.baseUrl + "save", formData);

  }
  deleteMedicine(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}delete/${id}`);
  }

  updateMedicine(id: number, medicine: MedicineModel, image?: File): Observable<any> {
    const formData = new FormData();

   
    formData.append('hotel', new Blob([JSON.stringify(medicine)], { type: 'application/json' }));


    if (image) {
        formData.append('image', image);
    }

    return this.httpClient.put(this.baseUrl + 'updatemedicine/' + id, formData);
}

getMedicineById(medicineId: number): Observable<any> {
  return this.httpClient.get<any>(this.baseUrl + medicineId);
}


}
