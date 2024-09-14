import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalesOrderModel } from '../model/salesOrder.model';

@Injectable({
  providedIn: 'root'
})
export class SalesOrderService {

  baseUrl: string = "http://localhost:8087/api/salesorder/"

  constructor(private httpClient: HttpClient) { }

  getAllSalesOrder(): Observable<any> {
    return this.httpClient.get(this.baseUrl);
  }

  createSalesOrder(salesOrder: SalesOrderModel): Observable<any> {

    return this.httpClient.post(this.baseUrl + "save", salesOrder);
  }

}
