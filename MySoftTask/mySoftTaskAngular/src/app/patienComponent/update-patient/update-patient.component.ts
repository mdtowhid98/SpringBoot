import { Component, OnInit } from '@angular/core';
import { PatientModel } from '../../model/patientModel';
import { PatientService } from '../../service/patient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent implements OnInit{

  id: number = 0;
    registrations: PatientModel = new PatientModel();
  
    constructor(private patientService: PatientService,
      private router: Router,
      private route: ActivatedRoute
    ) { }
  
  
  
  
  
  
    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.patientService.getById(this.id)
        .subscribe({
  
          next: res => {
            this.registrations = res;
            console.log(this.registrations);
            console.log(res);
          },
          error: error => {
            console.log(error);
          }
  
        });
    }
  
    updateRegister() {
  
      this.patientService.updatePatient(this.id, this.registrations)
  
        .subscribe({
          next: res => {
            console.log(res);
  
            this.router.navigate(['/registration']);
          },
          error: error => {
            console.log(error);
          }
  
        });
    }

}
