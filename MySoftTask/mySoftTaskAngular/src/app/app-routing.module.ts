import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ViewPatientComponent } from './patienComponent/view-patient/view-patient.component';
import { CreatePatientComponent } from './patienComponent/create-patient/create-patient.component';
import { UpdatePatientComponent } from './patienComponent/update-patient/update-patient.component';

const routes: Routes = [

  { path: '', redirectTo: '/registration', pathMatch: 'full' }, // Default route to Show Patient

  {path:"registration",component:ViewPatientComponent},
  {path:"createregistration",component:CreatePatientComponent},
  {path:"updategistration/:id",component:UpdatePatientComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
