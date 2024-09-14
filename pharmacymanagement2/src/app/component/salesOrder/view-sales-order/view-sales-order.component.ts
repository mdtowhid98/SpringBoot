import { Component, OnInit } from '@angular/core';
import { SalesOrderModel } from '../../../model/salesOrder.model';
import { PharmacistService } from '../../../service/pharmacist.service';
import { CustomerService } from '../../../service/customer.service';
import { Router } from '@angular/router';
import { SalesOrderService } from '../../../service/sales-order.service';
import { error } from 'console';
import { CustomerModel } from '../../../model/customer.model';

@Component({
  selector: 'app-view-sales-order',
  templateUrl: './view-sales-order.component.html',
  styleUrls: ['./view-sales-order.component.css']  // Make sure it's styleUrls, not styleUrl
})
export class ViewSalesOrderComponent implements OnInit {

 


  pharmacist: any;
  customers: any;
  salesOrders: SalesOrderModel[] = [];

  constructor(
    private pharmacistService: PharmacistService,
    private customerService: CustomerService,
    private salesOrderService: SalesOrderService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadSalesOrder();
  }

 

   loadSalesOrder() {
    this.pharmacist = this.pharmacistService.getAllPharmacist();
    this.customers = this.customerService.getAllCustomer();
    
    this.salesOrderService.getAllSalesOrder().subscribe({
      next: (res:SalesOrderModel[]) => {
        this.salesOrders=res;
      },
      error: err => {
        console.log(err);
      }
    });
  }
  
}
