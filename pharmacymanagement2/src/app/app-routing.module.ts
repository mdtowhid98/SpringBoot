import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewMedicineGenericComponent } from './component/medicineGeneric/view-medicine-generic/view-medicine-generic.component';
import { CreateMedicineGenericComponent } from './component/medicineGeneric/create-medicine-generic/create-medicine-generic.component';
import { ViewMedicineComponent } from './component/medicine/view-medicine/view-medicine.component';
import { CreateMedicineComponent } from './component/medicine/create-medicine/create-medicine.component';
import { ViewPharmacistComponent } from './component/pharmacist/view-pharmacist/view-pharmacist.component';
import { CreatePharmacistComponent } from './component/pharmacist/create-pharmacist/create-pharmacist.component';
import { UpdateMedicineGenericComponent } from './component/medicineGeneric/update-medicine-generic/update-medicine-generic.component';
import { ViewCustomerComponent } from './component/customer/view-customer/view-customer.component';
import { CreateCustomerComponent } from './component/customer/create-customer/create-customer.component';
import { UpdatemedicineComponent } from './component/medicine/updatemedicine/updatemedicine.component';
import { UpdatePharmacistComponent } from './component/pharmacist/update-pharmacist/update-pharmacist.component';
import { ViewSalesOrderComponent } from './component/salesOrder/view-sales-order/view-sales-order.component';
import { CreateSalesOrderComponent } from './component/salesOrder/create-sales-order/create-sales-order.component';
import { ViewSalesMedicineComponent } from './component/salesMedicine/view-sales-medicine/view-sales-medicine.component';

const routes: Routes = [
  {path:"viewgeneric",component:ViewMedicineGenericComponent},
  {path:"creategeneric",component:CreateMedicineGenericComponent},
  {path:"viewmedicine",component:ViewMedicineComponent},
  {path:"createmedicine",component:CreateMedicineComponent},
  {path:"viewpharmacist",component:ViewPharmacistComponent},
  {path:"createpharmacist",component:CreatePharmacistComponent},
  {path:"updategeneric/:id",component:UpdateMedicineGenericComponent},
  {path:"viewcustomer",component:ViewCustomerComponent},
  {path:"createcustomer",component:CreateCustomerComponent},
  {path:"updatemedicine/:id",component:UpdatemedicineComponent},
  {path:"updatepharmacist/:id",component:UpdatePharmacistComponent},
  {path:"viewsalesorder",component:ViewSalesOrderComponent},
  {path:"createsalesorder",component:CreateSalesOrderComponent},
  {path:"viewSalesMedicine",component:ViewSalesMedicineComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
