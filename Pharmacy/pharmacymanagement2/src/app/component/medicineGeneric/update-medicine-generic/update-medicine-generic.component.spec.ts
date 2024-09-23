import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMedicineGenericComponent } from './update-medicine-generic.component';

describe('UpdateMedicineGenericComponent', () => {
  let component: UpdateMedicineGenericComponent;
  let fixture: ComponentFixture<UpdateMedicineGenericComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdateMedicineGenericComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateMedicineGenericComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
