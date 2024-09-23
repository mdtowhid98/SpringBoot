import { Component } from '@angular/core';
import { PharmacistModel } from '../../../model/pharmacist.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PharmacistService } from '../../../service/pharmacist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-pharmacist',
  templateUrl: './create-pharmacist.component.html',
  styleUrl: './create-pharmacist.component.css'
})
export class CreatePharmacistComponent {

  formValue!: FormGroup;

  constructor(private formBuilder: FormBuilder, 
    private pharmacistService: PharmacistService,
    private router:Router
  ) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['', Validators.required]
    });
  }

  createPharmacist() {
    if (this.formValue.valid) {
      const pharmacistData = this.formValue.value;
      // Call the service to create the pharmacist, pass `pharmacistData`
      this.pharmacistService.createpharmacist(pharmacistData).subscribe({
        next: (res) => {
          console.log('Pharmacist added successfully', res);
          this.formValue.reset();
          this.router.navigate(['/viewpharmacist']);
        },
        error: (err) => {
          console.error('Error while adding pharmacist', err);
        }
      });
    }
  }
}
