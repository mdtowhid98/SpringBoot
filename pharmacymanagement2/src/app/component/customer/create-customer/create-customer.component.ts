import { Component, OnInit } from '@angular/core';
import { CustomerModel } from '../../../model/customer.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../../service/customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrl: './create-customer.component.css'
})
export class CreateCustomerComponent implements OnInit{

 
  formGroup!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router:Router
  ) {}

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      address: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.formGroup.valid) {
      const customerData = this.formGroup.value;

      // Call the service to save data
      this.customerService.saveCustomer(customerData).subscribe(
        response => {
          console.log('Customer saved successfully:', response);
          // Optionally, reset the form or navigate to another page
          this.formGroup.reset();
          this.router.navigate(['viewcustomer'])
        },
        error => {
          console.error('Error saving customer:', error);
        }
      );
    } else {
      console.error('Form is invalid');
      this.formGroup.markAllAsTouched();
    }
  }


}
