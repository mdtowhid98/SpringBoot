import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../util/api.response.model';
import { CustomerModel } from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {


  baseUrl: string = "http://localhost:8087/api/customer/"


  constructor(private httpClient: HttpClient) { }

  getAllCustomer(): Observable<ApiResponse> {
    return this.httpClient.get<ApiResponse>(this.baseUrl);
  }

  // createCustomer(customer: CustomerModel): Observable<ApiResponse> {

  //   // const formData = new FormData();

   

  //   return this.httpClient.post<ApiResponse>(this.baseUrl + "save", customer);

  // }

  saveCustomer(customerData: any): Observable<any> {
    return this.httpClient.post(this.baseUrl+"save", customerData);
  }




}
