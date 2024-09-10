import { Component } from '@angular/core';
import { MedicineModel } from '../../../model/medicine.model';
import { MedicineGenericModel } from '../../../model/medicineGeneric.model';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MedicineService } from '../../../service/medicine.service';
import { Router } from '@angular/router';
import { MedicineGenericService } from '../../../service/medicine-generic.service';

@Component({
  selector: 'app-create-medicine',
  templateUrl: './create-medicine.component.html',
  styleUrl: './create-medicine.component.css'
})
export class CreateMedicineComponent {


  image: File | null = null;
  medicine: MedicineModel = new MedicineModel();
  generics: MedicineGenericModel[] = [];
  formGroup!: FormGroup;

  constructor(
    private medicineService: MedicineService,
    private formBuilder: FormBuilder,
    private router: Router,
    private genericService: MedicineGenericService
  ) { }

  ngOnInit(): void {
    this.loadGenerics();


    this.formGroup = this.formBuilder.group({
      name: [''],
      manufacturer: [''],
      price: [''],
      quantity: [''],
      expiryDate: [''],
      manufacturerDate: [''],
      image: [''],
      generic: [null]
    });


  }

  onFileSelected(event: any) {
    this.image = event.target.files[0];
  }

  loadGenerics() {
    this.genericService.getAllMedicineGeneric().subscribe({
      next: res => {
        this.generics = res;
        console.log(this.generics);
      },
      error: err => {
        console.error('Error fetching generics:', err);
      }
    });
  }

  onSubmit() {
    if (this.image) {

      const medicine: MedicineModel = {
        ...this.formGroup.value,
        generic: { id: this.formGroup.value.generic } as MedicineGenericModel
      };

      this.medicineService.createMedicine(medicine, this.image).subscribe({
        next: apiResponse => {
          if (apiResponse && apiResponse.successful) {
            console.log(apiResponse.message);
            this.formGroup.reset();
            this.router.navigate(['/viewmedicine']);
          }
        },
        error: err => {
          console.error('Error adding medicine:', err.apiResponse?.message);
        }
      });
    } else {
      alert('Please select an image.');
    }
  }

  


}
