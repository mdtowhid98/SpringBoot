import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePharmacistComponent } from './create-pharmacist.component';

describe('CreatePharmacistComponent', () => {
  let component: CreatePharmacistComponent;
  let fixture: ComponentFixture<CreatePharmacistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CreatePharmacistComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePharmacistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
