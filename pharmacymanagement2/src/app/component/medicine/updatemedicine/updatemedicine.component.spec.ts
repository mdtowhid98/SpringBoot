import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatemedicineComponent } from './updatemedicine.component';

describe('UpdatemedicineComponent', () => {
  let component: UpdatemedicineComponent;
  let fixture: ComponentFixture<UpdatemedicineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UpdatemedicineComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatemedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
