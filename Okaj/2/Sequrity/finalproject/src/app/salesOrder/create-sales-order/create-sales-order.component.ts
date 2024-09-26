import { Component, OnInit } from '@angular/core';
import { CustomerModule } from '../../module/customer/customer.module';
import { SupplierModule } from '../../module/supplier/supplier.module';
import { ProductModule } from '../../module/product/product.module';
import { ProductService } from '../../service/product.service';
import { SalesOrderService } from '../../service/sales-order.service';
import { CustomerService } from '../../service/customer.service';
import { SupplierService } from '../../service/supplier.service';
import { Router } from '@angular/router';
import { SalesOrderModule } from '../../module/sales-order/sales-order.module';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-sales-order',
  templateUrl: './create-sales-order.component.html',
  styleUrl: './create-sales-order.component.css'
})
export class CreateSalesOrderComponent implements OnInit{


  formValue!: FormGroup;
  customers: any[] = [];
  suppliers: any[] = [];
  products: any[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private customerService: CustomerService,
    private supplierService: SupplierService,
    private salesOrderService: SalesOrderService, // Inject SalesOrderService
    private router: Router // Inject Router for navigation
  ) {}

  ngOnInit(): void {
    this.loadCustomers();
    this.loadSuppliers();
    this.loadProducts();

    this.formValue = this.formBuilder.group({
      orderDate: ['', Validators.required],
      totalAmount: ['', [Validators.required, Validators.min(0)]], // Adding min validation
      customer: ['', Validators.required],
      supplier: ['', Validators.required],
      products: this.formBuilder.array([], Validators.required) // Initialize the FormArray
    });
  }

  loadCustomers() {
    this.customerService.getAllCustomer().subscribe(customers => {
      this.customers = customers;
    });
  }

  loadSuppliers() {
    this.supplierService.getAllSupplier().subscribe(suppliers => {
      this.suppliers = suppliers;
    });
  }

  loadProducts() {
    this.productService.getAllProducts().subscribe(products => {
      this.products = products;
      this.initializeProductCheckboxes(); // Initialize the checkboxes after products are loaded
    });
  }

  initializeProductCheckboxes() {
    const productFormArray = this.formValue.get('products') as FormArray;
    productFormArray.clear(); // Clear previous controls if any
    this.products.forEach(() => productFormArray.push(this.formBuilder.control(false))); // Push a new control for each product
  }

  onSubmit() {
    if (this.formValue.valid) {
      const selectedProducts = this.formValue.value.products
        .map((selected: boolean, i: number) => selected ? this.products[i].id : null)
        .filter((productId: string | null) => productId !== null);
      
      const salesOrder = {
        orderDate: this.formValue.value.orderDate,
        totalAmount: this.formValue.value.totalAmount,
        customer: this.formValue.value.customer,
        supplier: this.formValue.value.supplier,
        products: selectedProducts
      };

      
      this.salesOrderService.createSalesOrder(salesOrder).subscribe({
        next: (response) => {
          console.log('Sales Order Created:', response);
          
          this.router.navigate(['/viewsalesorder']); 
        },
        error: (error) => {
          console.error('Error creating sales order:', error);
          
        }
      });
    } else {
      
      console.log('Form is invalid');
    }
  }
}