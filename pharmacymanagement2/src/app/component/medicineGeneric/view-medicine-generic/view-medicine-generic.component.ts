import { Component, OnInit } from '@angular/core';
import { MedicineGenericService } from '../../../service/medicine-generic.service';
import { MedicineGenericModel } from '../../../model/medicineGeneric.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-medicine-generic',
  templateUrl: './view-medicine-generic.component.html',
  styleUrl: './view-medicine-generic.component.css'
})
export class ViewMedicineGenericComponent implements OnInit {

  generics: MedicineGenericModel[] = [];

  constructor(
    private genericService: MedicineGenericService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadGenerics();
  }

  // Helper method to load the generics
  loadGenerics() {
    this.genericService.getAllMedicineGeneric().subscribe({
      next: (data: MedicineGenericModel[]) => {
        this.generics = data;
      },
      error: (error) => {
        console.log('Error fetching generics', error);
      }
    });
  }

  // Delete method
  deleteMedicineGeneric(id: number) {
    if (confirm('Are you sure you want to delete this generic?')) {
      this.genericService.deleteMedicineGeneric(id).subscribe({
        next: () => {
          // Refresh the generics list after successful deletion
          this.loadGenerics();
        },
        error: (error) => {
          console.log('Error deleting generic', error);
        }
      });
    }
  }

  updateMedicineGeneric(id: number) {

    this.router.navigate(['/updategeneric', id]);
  }


}
