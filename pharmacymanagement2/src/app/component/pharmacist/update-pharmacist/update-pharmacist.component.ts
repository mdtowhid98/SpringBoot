import { Component, OnInit } from '@angular/core';
import { PharmacistModel } from '../../../model/pharmacist.model';
import { PharmacistService } from '../../../service/pharmacist.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-pharmacist',
  templateUrl: './update-pharmacist.component.html',
  styleUrl: './update-pharmacist.component.css'
})
export class UpdatePharmacistComponent implements OnInit{

  id: number=0;
  pharmacist: PharmacistModel = new PharmacistModel();

  constructor(private pharmacistService: PharmacistService,
    private router: Router,
    private route: ActivatedRoute
  ) { }






  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.pharmacistService.getById(this.id)
      .subscribe({

        next: res => {
          this.pharmacist = res;
          console.log(this.pharmacist);
          console.log(res);
        },
        error: error => {
          console.log(error);
        }

      });
  }

  updatePharmacist() {

    this.pharmacistService.updatePharmacist(this.id, this.pharmacist)

      .subscribe({
        next: res => {
         console.log(res);
         
          this.router.navigate(['/viewpharmacist']);
        },
        error: error => {
          console.log(error);
        }

      });
  }
  


}
