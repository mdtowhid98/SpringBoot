import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMedicineGenericComponent } from './view-medicine-generic.component';

describe('ViewMedicineGenericComponent', () => {
  let component: ViewMedicineGenericComponent;
  let fixture: ComponentFixture<ViewMedicineGenericComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewMedicineGenericComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewMedicineGenericComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
