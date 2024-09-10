import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewMedicineGenericComponent } from './component/medicineGeneric/view-medicine-generic/view-medicine-generic.component';
import { CreateMedicineGenericComponent } from './component/medicineGeneric/create-medicine-generic/create-medicine-generic.component';
import { ViewMedicineComponent } from './component/medicine/view-medicine/view-medicine.component';
import { CreateMedicineComponent } from './component/medicine/create-medicine/create-medicine.component';
import { ViewPharmacistComponent } from './component/pharmacist/view-pharmacist/view-pharmacist.component';
import { CreatePharmacistComponent } from './component/pharmacist/create-pharmacist/create-pharmacist.component';
import { UpdateMedicineGenericComponent } from './component/medicineGeneric/update-medicine-generic/update-medicine-generic.component';

const routes: Routes = [
  {path:"viewgeneric",component:ViewMedicineGenericComponent},
  {path:"creategeneric",component:CreateMedicineGenericComponent},
  {path:"viewmedicine",component:ViewMedicineComponent},
  {path:"createmedicine",component:CreateMedicineComponent},
  {path:"viewpharmacist",component:ViewPharmacistComponent},
  {path:"createpharmacist",component:CreatePharmacistComponent},
  {path:"updategeneric/:id",component:UpdateMedicineGenericComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
