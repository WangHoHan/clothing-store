import { ShoppingBagService } from './shopping-bag.service';
import { TestBed } from '@angular/core/testing';

describe('ShoppingBagService', () => {
  let service: ShoppingBagService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShoppingBagService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
