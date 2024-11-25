import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GulshanbranchstockComponent } from './gulshanbranchstock.component';

describe('GulshanbranchstockComponent', () => {
  let component: GulshanbranchstockComponent;
  let fixture: ComponentFixture<GulshanbranchstockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GulshanbranchstockComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GulshanbranchstockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
