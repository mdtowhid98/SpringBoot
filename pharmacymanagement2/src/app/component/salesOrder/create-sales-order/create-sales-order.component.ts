import { Component, OnInit } from '@angular/core';
import { SalesOrderModel } from '../../../model/salesOrder.model';
import { CustomerModel } from '../../../model/customer.model';
import { PharmacistModel } from '../../../model/pharmacist.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SalesOrderService } from '../../../service/sales-order.service';
import { Router } from '@angular/router';
import { CustomerService } from '../../../service/customer.service';
import { PharmacistService } from '../../../service/pharmacist.service';
import { ApiResponse } from '../../../util/api.response.model';

@Component({
  selector: 'app-create-sales-order',
  templateUrl: './create-sales-order.component.html',
  styleUrls: ['./create-sales-order.component.css']
})
export class CreateSalesOrderComponent implements OnInit {
  salesOrder: SalesOrderModel = new SalesOrderModel();
  customers: CustomerModel[] = [];
  pharmacists: PharmacistModel[] = [];
  formGroup!: FormGroup;

  constructor(
    private salesOrderService: SalesOrderService,
    private formBuilder: FormBuilder,
    private router: Router,
    private customerService: CustomerService,
    private pharmacistService: PharmacistService
  ) { }

  ngOnInit(): void {
    this.loadCustomers();
    this.loadPharmacists();

    // Initializing the form with validators
    this.formGroup = this.formBuilder.group({
      customer: [null, Validators.required],
      pharmacist: [null, Validators.required],
      orderDate: ['', Validators.required],
      totalAmount: ['', Validators.required]
    });
  }

  // Load customers from the service
  loadCustomers() {
    this.customerService.getAllCustomer().subscribe({
      next: (res: ApiResponse) => {
        if (res.successful) {
          this.customers = res.data;  // Ensure res.data contains the list of customers
        } else {
          console.error('Error fetching customers:', res.message);
        }
      },
      error: err => {
        console.error('Error fetching customers:', err);
      }
    });
  }

  // Load pharmacists from the service
  loadPharmacists() {
    this.pharmacistService.getAllPharmacist().subscribe({
      next: (res: ApiResponse) => {
        if (res.successful) {
          this.pharmacists = res.data;  // Ensure res.data contains the list of pharmacists
        } else {
          console.error('Error fetching pharmacists:', res.message);
        }
      },
      error: err => {
        console.error('Error fetching pharmacists:', err);
      }
    });
  }

  // Handle form submission
  onSubmit() {
    if (this.formGroup.valid) {
      this.salesOrder.customer = this.customers.find(c => c.id === this.formGroup.value.customer) as CustomerModel;
      this.salesOrder.pharmacist = this.pharmacists.find(p => p.id === this.formGroup.value.pharmacist) as PharmacistModel;
      this.salesOrder.orderDate = this.formGroup.value.orderDate;
      this.salesOrder.totalAmount = this.formGroup.value.totalAmount;

      this.salesOrderService.createSalesOrder(this.salesOrder).subscribe({
        next: apiResponse => {
          if (apiResponse && apiResponse.successful) {
            this.formGroup.reset();
            this.router.navigate(['/view-sales-orders']);
          }
        },
        error: err => {
          console.error('Error creating sales order:', err.apiResponse?.message);
        }
      });
    } else {
      console.error('Form is invalid');
    }
  }
}
