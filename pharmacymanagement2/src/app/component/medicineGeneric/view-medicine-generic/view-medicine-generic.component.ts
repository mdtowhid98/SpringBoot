import { Component, OnInit } from '@angular/core';
import { MedicineGenericService } from '../../../service/medicine-generic.service';

@Component({
  selector: 'app-view-medicine-generic',
  templateUrl: './view-medicine-generic.component.html',
  styleUrl: './view-medicine-generic.component.css'
})
export class ViewMedicineGenericComponent implements OnInit{

  generics:any;

  constructor(
    private genericService:MedicineGenericService
  ){}
  
    ngOnInit(): void {
      this.generics=this.genericService.getAllMedicineGeneric();
    }


}
