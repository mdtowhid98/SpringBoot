import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BananibranchstockComponent } from './bananibranchstock.component';

describe('BananibranchstockComponent', () => {
  let component: BananibranchstockComponent;
  let fixture: ComponentFixture<BananibranchstockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BananibranchstockComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BananibranchstockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
