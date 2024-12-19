import { Component, OnInit } from '@angular/core';
import { PatientModel } from '../../model/patientModel';
import { PatientService } from '../../service/patient.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrl: './view-patient.component.css'
})
export class ViewPatientComponent implements OnInit{

registrations: PatientModel[] = [];

  constructor(
    private patientService: PatientService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadRegisters();
  }

  loadRegisters() {
    this.patientService.getAllRegisterPatient().subscribe({
      next: (data: PatientModel[]) => {
        this.registrations = data;
      },
      error: (error) => {
        console.log('Error fetching Register Patient', error);
      }
    });
  }

  // Calculate the age from Date of Birth (DoB)
  calculateAge(dob: Date | string): string {
    const birthDate = new Date(dob); // Ensure dob is treated as a Date object
    const today = new Date();
    let ageYears = today.getFullYear() - birthDate.getFullYear();
    let ageMonths = today.getMonth() - birthDate.getMonth();
    let ageDays = today.getDate() - birthDate.getDate();

    if (ageDays < 0) {
      ageMonths--;
      ageDays += new Date(today.getFullYear(), today.getMonth(), 0).getDate(); // Get days in previous month
    }

    if (ageMonths < 0) {
      ageYears--;
      ageMonths += 12;
    }

    return `${ageYears} years, ${ageMonths} months, ${ageDays} days`;
  }

  deleteRegister(id: number) {
    if (confirm('Are you sure you want to delete this Patient?')) {
      this.patientService.deletePatient(id).subscribe({
        next: () => {
          this.loadRegisters();
        },
        error: (error) => {
          console.log('Error deleting Patient', error);
        }
      });
    }
  }

  updateRegister(id: number) {
    this.router.navigate(['/updategistration', id]);
  }



}
