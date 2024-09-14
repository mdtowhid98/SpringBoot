import { Component, OnInit } from '@angular/core';
import { MedicineService } from '../../../service/medicine.service';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { Router } from '@angular/router';
import { MedicineModel } from '../../../model/medicine.model';

@Component({
  selector: 'app-view-medicine',
  templateUrl: './view-medicine.component.html',
  styleUrl: './view-medicine.component.css'
})
export class ViewMedicineComponent implements OnInit{


  generics: any;
  medicines: MedicineModel[] = [];
  

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

      next: apiResponse => {
        console.log(apiResponse)
        if (apiResponse && apiResponse.successful) {
          this.medicines = apiResponse.data['medicines'];
        } else {
          alert('No medicine found')
        }
      },
      error: err => {
        alert(err.apiResponse?.message);
      }

    });


  }

  // Delete method
  deleteMedicine(id: number) {
    if (confirm('Are you sure you want to delete this generic?')) {
      this.medicineService.deleteMedicine(id).subscribe({
        next: () => {
          // Refresh the generics list after successful deletion
          this.loadMedicine();
        },
        error: (error) => {
          console.log('Error deleting generic', error);
        }
      });
    }
  }

  updateMedicine(id: number) {
    this.router.navigate(['/updatemedicine',id]);

  }

 


}
