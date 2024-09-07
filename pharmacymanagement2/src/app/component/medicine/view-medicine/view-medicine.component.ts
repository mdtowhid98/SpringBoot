import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../../../service/medicine.service';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-medicine',
  templateUrl: './view-medicine.component.html',
  styleUrl: './view-medicine.component.css'
})
export class ViewMedicineComponent implements OnInit{


  generics: any;
  medicine: any;
  

  constructor(
    private medicineService: MedicineService,
    private genericService:MedicineGenericService,
   
    private router: Router

  ) { }

  ngOnInit(): void {

    this.loadMedicine();
  }


  loadMedicine() {

    this.generics = this.genericService.getAllMedicineGeneric();
    this.medicineService.getAllMedicine().subscribe({

      next: res => {
        this.medicine = res;
      },

      error: err => {
        console.log(err)

      }

    });


  }

 


}
