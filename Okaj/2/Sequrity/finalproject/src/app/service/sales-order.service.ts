import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SalesOrderModule } from '../module/sales-order/sales-order.module';

@Injectable({
  providedIn: 'root'
})
export class SalesOrderService {

  baseUrl: string = "http://localhost:8087/api/salesorder/";

  constructor(private httpClient: HttpClient) { }

  // Fetch all sales orders
  getAllSalesOrder(): Observable<SalesOrderModule[]> {
    return this.httpClient.get<SalesOrderModule[]>(this.baseUrl);
  }

  // Create a new sales order
  createSalesOrder(order: SalesOrderModule): Observable<any> {
    return this.httpClient.post(this.baseUrl + "save", order);
  }

}
