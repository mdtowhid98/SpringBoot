import { Component } from '@angular/core';
import { PharmacistService } from '../../../service/pharmacist.service';

@Component({
  selector: 'app-view-pharmacist',
  templateUrl: './view-pharmacist.component.html',
  styleUrl: './view-pharmacist.component.css'
})
export class ViewPharmacistComponent {

  pharmacists:any;

  constructor(
    private pharmacistService:PharmacistService
  ){}
  
    ngOnInit(): void {
      this.pharmacists=this.pharmacistService.getAllPharmacist();
    }


}
