import { TestBed } from '@angular/core/testing';

import { MedicineGenericService } from './medicine-generic.service';

describe('MedicineGenericService', () => {
  let service: MedicineGenericService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicineGenericService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
