import { Component } from '@angular/core';
import { MedicineGenericModel } from '../../../model/medicineGeneric.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-medicine-generic',
  templateUrl: './create-medicine-generic.component.html',
  styleUrl: './create-medicine-generic.component.css'
})
export class CreateMedicineGenericComponent {

  generic: MedicineGenericModel = new MedicineGenericModel();

  formValue!: FormGroup;
  genericData: any;

  constructor(private genericService: MedicineGenericService,
    private router: Router,
  
    private formBuilder: FormBuilder
  ) {


  }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({

      name: [''],
      

    });

  }


  createGenrics() {

    this.generic.name = this.formValue.value.name;
    


    this.genericService.createMedicineGeneric(this.generic)
      .subscribe({
        next: res => {
          console.log(res);
          this.formValue.reset();
          this.router.navigate(['/viewgeneric']);
        },
        error: error => {

          console.log(error);
        }

      });



  }






}
