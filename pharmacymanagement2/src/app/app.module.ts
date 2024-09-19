import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch } from '@angular/common/http';
import { ViewMedicineGenericComponent } from './component/medicineGeneric/view-medicine-generic/view-medicine-generic.component';
import { CreateMedicineGenericComponent } from './component/medicineGeneric/create-medicine-generic/create-medicine-generic.component';
import { CreateMedicineComponent } from './component/medicine/create-medicine/create-medicine.component';
import { ViewMedicineComponent } from './component/medicine/view-medicine/view-medicine.component';
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
import { RegisterComponent } from './component/register/register.component';
import { LoginComponent } from './component/login/login.component';
import { TokenInterceptor } from './model/TokenInterceptor';


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
    CreateCustomerComponent,
    UpdatemedicineComponent,
    UpdatePharmacistComponent,
    ViewSalesOrderComponent,
    CreateSalesOrderComponent,
    ViewSalesMedicineComponent,
    RegisterComponent,
    LoginComponent,
    
  
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
    ),
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
