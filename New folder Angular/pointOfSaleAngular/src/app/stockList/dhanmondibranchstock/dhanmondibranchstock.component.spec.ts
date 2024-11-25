import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DhanmondibranchstockComponent } from './dhanmondibranchstock.component';

describe('DhanmondibranchstockComponent', () => {
  let component: DhanmondibranchstockComponent;
  let fixture: ComponentFixture<DhanmondibranchstockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DhanmondibranchstockComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DhanmondibranchstockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
