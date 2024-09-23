import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMedicineGenericComponent } from './create-medicine-generic.component';

describe('CreateMedicineGenericComponent', () => {
  let component: CreateMedicineGenericComponent;
  let fixture: ComponentFixture<CreateMedicineGenericComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreateMedicineGenericComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateMedicineGenericComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
