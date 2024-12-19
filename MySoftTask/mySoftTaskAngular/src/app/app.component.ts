import { Component, Inject, PLATFORM_ID } from '@angular/core';

import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  constructor( private router:Router,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}


}
