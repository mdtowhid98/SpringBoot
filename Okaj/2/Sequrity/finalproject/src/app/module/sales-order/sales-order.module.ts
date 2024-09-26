import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerModule } from '../customer/customer.module';
import { SupplierModule } from '../supplier/supplier.module';
import { ProductModule } from '../product/product.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class SalesOrderModule { 
  id?: number;           // Optional ID field
  orderDate!: Date;      // Ensure orderDate is of type Date
  totalAmount!: number;  // Total amount for the order
  customer!: CustomerModule; // Customer associated with the order
  supplier!: SupplierModule; // Supplier associated with the order
  products!: ProductModule[]; // List of products associated with the order
}
