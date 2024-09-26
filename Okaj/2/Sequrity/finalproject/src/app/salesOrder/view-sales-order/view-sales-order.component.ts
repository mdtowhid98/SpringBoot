import { Component, OnInit } from '@angular/core';
import { SalesOrderModule } from '../../module/sales-order/sales-order.module';
import { ProductModule } from '../../module/product/product.module';
import { CustomerModule } from '../../module/customer/customer.module';
import { SupplierModule } from '../../module/supplier/supplier.module';
import { faEdit, faEye, faTrash } from '@fortawesome/free-solid-svg-icons';
import { ProductService } from '../../service/product.service';
import { SalesOrderService } from '../../service/sales-order.service';
import { CustomerService } from '../../service/customer.service';
import { SupplierService } from '../../service/supplier.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-sales-order',
  templateUrl: './view-sales-order.component.html',
  styleUrl: './view-sales-order.component.css'
})
export class ViewSalesOrderComponent implements OnInit{

  order: SalesOrderModule[] = [];
  products: ProductModule[] = [];
  customer:CustomerModule[]=[];
  supplier:SupplierModule[]=[];
  
  faEdit = faEdit;
  faTrash = faTrash;
  faEye = faEye;

  constructor(private productService:ProductService,
    private orderService:SalesOrderService,
    private customerService:CustomerService,
    private supplierService:SupplierService,
    private router:Router
  ){}
  
    ngOnInit(): void {
      this.loadProducts();
      this.loadSalesOrder();
      this.loadCustomer();
      this.loadSupplier();
    }

    loadProducts() {
      this.productService.getAllProductForSales().subscribe({
        next: (res: ProductModule[]) => {
          this.products = res;
          // console.log(this.products); // Log the products array
        },
        error: error => {
          console.error(error);
        }
      });
    }

    loadCustomer() {
      this.customerService.getAllCustomer().subscribe({
        next: (res: CustomerModule[]) => {
          this.customer = res;
          // console.log(this.products); // Log the products array
        },
        error: error => {
          console.error(error);
        }
      });
    }

    loadSupplier() {
      this.supplierService.getAllSupplier().subscribe({
        next: (res: SupplierModule[]) => {
          this.supplier = res;
          // console.log(this.products); // Log the products array
        },
        error: error => {
          console.error(error);
        }
      });
    }

  
    loadSalesOrder() {
      this.orderService.getAllSalesOrder().subscribe({
        next: (res: SalesOrderModule[]) => {
          this.order = res;
          // console.log(this.sales); // Log the sales array
        },
        error: error => {
          console.error(error);
        }
      });
    }

    


    // deleteSales(id:number){

    //   this.salesService.deleteSales(id)
    //   .subscribe({
    //     next:res=>{
    //       this.loadSales();
    //       this.router.navigate(['/viewsales'])
    //     },
    //     error:error=>{
    //       console.log(error);
    //     }
  
    //   });
    // }

    // editSales(sale: SalesModule): void {
    
    //   this.router.navigate(['/updateSales', sale.id]);
    // }


}
