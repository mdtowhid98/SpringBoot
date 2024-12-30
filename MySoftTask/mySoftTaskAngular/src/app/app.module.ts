import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgxPrintModule } from 'ngx-print';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch } from '@angular/common/http';

// Import FontAwesomeModule
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';


import { NavbarComponent } from './navbar/navbar.component';
import { ViewPatientComponent } from './patienComponent/view-patient/view-patient.component';
import { CreatePatientComponent } from './patienComponent/create-patient/create-patient.component';
import { UpdatePatientComponent } from './patienComponent/update-patient/update-patient.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ViewPatientComponent,
    CreatePatientComponent,
    UpdatePatientComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    NgxPrintModule, 
    FontAwesomeModule
  ],
  providers: [
    provideHttpClient(
      withFetch()
    ),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
