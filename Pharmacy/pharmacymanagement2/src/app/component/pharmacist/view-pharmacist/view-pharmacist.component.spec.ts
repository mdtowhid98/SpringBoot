import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPharmacistComponent } from './view-pharmacist.component';

describe('ViewPharmacistComponent', () => {
  let component: ViewPharmacistComponent;
  let fixture: ComponentFixture<ViewPharmacistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewPharmacistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewPharmacistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
