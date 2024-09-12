import { Component, OnInit } from '@angular/core';
import { MedicineGenericModel } from '../../../model/medicineGeneric.model';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-medicine-generic',
  templateUrl: './update-medicine-generic.component.html',
  styleUrl: './update-medicine-generic.component.css'
})
export class UpdateMedicineGenericComponent implements OnInit {


  id: number=0;
  generic: MedicineGenericModel = new MedicineGenericModel();

  constructor(private genericService: MedicineGenericService,
    private router: Router,
    private route: ActivatedRoute
  ) { }






  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.genericService.getById(this.id)
      .subscribe({

        next: res => {
          this.generic = res;
          console.log(this.generic );
          console.log(res);
        },
        error: error => {
          console.log(error);
        }

      });
  }

  updateMedicineGeneric() {

    this.genericService.updateMedicineGeneric(this.id, this.generic)

      .subscribe({
        next: res => {
         console.log(res);
         
          this.router.navigate(['/viewgeneric']);
        },
        error: error => {
          console.log(error);
        }

      });
  }
  



}
