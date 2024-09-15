import { TestBed } from '@angular/core/testing';

import { SalesMedicineService } from './sales-medicine.service';

describe('SalesMedicineService', () => {
  let service: SalesMedicineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SalesMedicineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
