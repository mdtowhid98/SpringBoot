import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../../service/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrl: './view-customer.component.css'
})
export class ViewCustomerComponent implements OnInit{

  customers: any;
  
  

  constructor(
    private customerService: CustomerService,
    
   
    private router: Router

  ) { }

  ngOnInit(): void {

    this.loadCustomer();
  }


  loadCustomer() {

 
    this.customerService.getAllCustomer().subscribe({

      next: apiResponse => {
        console.log(apiResponse)
        if (apiResponse && apiResponse.successful) {
          this.customers = apiResponse.data['customers'];
        } else {
          alert('No Customer found')
        }
      },
      error: err => {
        alert(err.apiResponse?.message);
      }

    });


  }

}
