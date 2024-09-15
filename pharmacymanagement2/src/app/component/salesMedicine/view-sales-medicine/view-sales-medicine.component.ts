import { Component, OnInit } from '@angular/core';
import { SalesMedicineModel } from '../../../model/salesMedicine.model';
import { MedicineModel } from '../../../model/medicine.model';
import { MedicineService } from '../../../service/medicine.service';
import { SalesMedicineService } from '../../../service/sales-medicine.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-sales-medicine',
  templateUrl: './view-sales-medicine.component.html',
  styleUrl: './view-sales-medicine.component.css'
})
export class ViewSalesMedicineComponent implements OnInit{


  salesMedicine: SalesMedicineModel[] = [];
  medicines: MedicineModel[] = [];
  
  // faEdit = faEdit;
  // faTrash = faTrash;
  // faEye = faEye;

  constructor(private medicineService:MedicineService,
    private salesMedicineService:SalesMedicineService,
    private router:Router
  ){}
  
    ngOnInit(): void {
      this.loadMedicines();
      this.loadSalesMedicines();
    }

    loadMedicines() {
      this.medicineService.getAllMedicineForSales().subscribe({
        next: (res: MedicineModel[]) => {
          this.medicines = res;
          
        },
        error: error => {
          console.error(error);
        }
      });
    }
  
    loadSalesMedicines() {
      this.salesMedicineService.getAllsalesMedicine().subscribe({
        next: (res: SalesMedicineModel[]) => {
          this.salesMedicine = res;
          
        },
        error: error => {
          console.error(error);
        }
      });
    }

    // deleteSales(id:string){

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
