import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PatientService } from '../../service/patient.service';
import { Router } from '@angular/router';
import { PatientModel } from '../../model/patientModel';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrl: './create-patient.component.css'
})
export class CreatePatientComponent implements OnInit{


  formValue!: FormGroup;
    age!: { years: number, months: number, days: number };
  
    constructor(
      private patientService: PatientService,
      private router: Router,
      private formBuilder: FormBuilder
    ) { }
  
    ngOnInit(): void {
      // Initialize the form with validation rules
      this.formValue = this.formBuilder.group({
        name: ['', [Validators.required, Validators.minLength(3)]],  
        dob: ['', Validators.required],
        mobile: ['', [Validators.required, Validators.pattern('^[0-9]{11}$')]], // Validates exactly 11-digit numbers
        gender: ['', Validators.required],
        presentAddress: ['', Validators.required],
        permanentAddress: ['', Validators.required]
      });
  
      // Listen for changes in the DoB field
      this.formValue.get('dob')?.valueChanges.subscribe(dob => {
        if (dob) {
          this.calculateAge(dob);
        }
      });
    }
  
    // Calculate the age based on DoB
    calculateAge(dob: string) {
      const birthDate = new Date(dob);
      const currentDate = new Date();
  
      let years = currentDate.getFullYear() - birthDate.getFullYear();
      let months = currentDate.getMonth() - birthDate.getMonth();
      let days = currentDate.getDate() - birthDate.getDate();
  
      if (days < 0) {
        months--;
        days += new Date(currentDate.getFullYear(), currentDate.getMonth(), 0).getDate();
      }
  
      if (months < 0) {
        years--;
        months += 12;
      }
  
      this.age = { years, months, days };
    }
  
    createRegister() {
      if (this.formValue.invalid) {
        alert('Please fill all required fields correctly.');
        return;
      }
  
      const registrationData: PatientModel = this.formValue.value;
  
      this.patientService.createPatient(registrationData).subscribe({
        next: res => {
          alert('Registration successful!');
          this.formValue.reset();
          this.router.navigate(['/registration']);
        },
        error: error => {
          alert('Failed to register! Please try again.');
          console.log(error);
        }
      });
    }

}
