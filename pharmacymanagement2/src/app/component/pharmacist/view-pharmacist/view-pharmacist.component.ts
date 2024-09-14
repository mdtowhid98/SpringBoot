import { Component } from '@angular/core';
import { PharmacistService } from '../../../service/pharmacist.service';
import { PharmacistModel } from '../../../model/pharmacist.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-pharmacist',
  templateUrl: './view-pharmacist.component.html',
  styleUrl: './view-pharmacist.component.css'
})
export class ViewPharmacistComponent {

  pharmacists:any;

  constructor(
    private pharmacistService:PharmacistService,
    private router:Router
  ){}
  
    ngOnInit(): void {
      this.pharmacists=this.pharmacistService.getAllPharmacist()
    }

    // loadPharmacist() {
    //   this.pharmacistService.getAllPharmacist().subscribe({
    //     next: (data: PharmacistModel[]) => {
    //       this.pharmacists = data;
    //     },
    //     error: (error) => {
    //       console.log('Error fetching generics', error);
    //     }
    //   });
    // }

    // Delete method
  deletePharmacist(id: number) {
    if (confirm('Are you sure you want to delete this pharmacist?')) {
      this.pharmacistService.deletePharmacist(id).subscribe({
        next: () => {
          // Refresh the generics list after successful deletion
          this.pharmacists();
          this.router.navigate(['/viewpharmacist'])
        },
        error: (error) => {
          console.log('Error deleting generic', error);
        }
      });
    }
  }

  updatePharmavcist(id: number) {

    this.router.navigate(['/updatepharmacist', id]);
  }


}
