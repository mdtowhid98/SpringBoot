import { Component, OnInit } from '@angular/core';
import { MedicineGenericModel } from '../../../model/medicineGeneric.model';
import { MedicineModel } from '../../../model/medicine.model';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { MedicineService } from '../../../service/medicine.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-updatemedicine',
  templateUrl: './updatemedicine.component.html',
  styleUrl: './updatemedicine.component.css'
})
export class UpdatemedicineComponent implements OnInit{




  generics: MedicineGenericModel[] = [];
  medicine: MedicineModel = new MedicineModel();
  selectedImage?: File;
  id: number = 0;

  constructor(
    private genericService: MedicineGenericService,
    private medicineService: MedicineService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']; 
    this.medicineService.getMedicineById(this.id).subscribe({
      next: (res) => {
        this.medicine = res;
        console.log(this.medicine);
      },
      error: (err) => {
        console.error(err);
      }
    });
    this.loadGenerics();
  }

  loadGenerics(): void {
    this.genericService.getAllCategoryforMedicine().subscribe({
      next: (res: MedicineGenericModel[]) => {
        this.generics = res;
      },
      error: (err) => {
        console.error(err);
      }
    });
  }

  onImageSelected(event: any): void {
    this.selectedImage = event.target.files[0];
  }

  

  updateMedicine(): void {
    this.medicineService.updateMedicine(this.id, this.medicine, this.selectedImage).subscribe({
      next: () => {
        this.router.navigate(['/viewmedicine']);  // Navigate to medicine list after successful update
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
  

}
