import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSalesMedicineComponent } from './view-sales-medicine.component';

describe('ViewSalesMedicineComponent', () => {
  let component: ViewSalesMedicineComponent;
  let fixture: ComponentFixture<ViewSalesMedicineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewSalesMedicineComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewSalesMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
