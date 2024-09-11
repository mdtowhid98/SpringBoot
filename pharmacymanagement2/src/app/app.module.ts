import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { ViewMedicineGenericComponent } from './component/medicineGeneric/view-medicine-generic/view-medicine-generic.component';
import { CreateMedicineGenericComponent } from './component/medicineGeneric/create-medicine-generic/create-medicine-generic.component';
import { CreateMedicineComponent } from './component/medicine/create-medicine/create-medicine.component';
import { ViewMedicineComponent } from './component/medicine/view-medicine/view-medicine.component';
import { ViewPharmacistComponent } from './component/pharmacist/view-pharmacist/view-pharmacist.component';
import { CreatePharmacistComponent } from './component/pharmacist/create-pharmacist/create-pharmacist.component';
import { UpdateMedicineGenericComponent } from './component/medicineGeneric/update-medicine-generic/update-medicine-generic.component';
import { ViewCustomerComponent } from './component/customer/view-customer/view-customer.component';
import { CreateCustomerComponent } from './component/customer/create-customer/create-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewMedicineGenericComponent,
    CreateMedicineGenericComponent,
    CreateMedicineComponent,
    ViewMedicineComponent,
    ViewPharmacistComponent,
    CreatePharmacistComponent,
    UpdateMedicineGenericComponent,
    ViewCustomerComponent,
    CreateCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    // provideClientHydration(),
    provideHttpClient(
      withFetch()
    )
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
