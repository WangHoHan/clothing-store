import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingBagComponent } from './shopping-bag.component';

describe('ShoppingBagComponent', () => {
  let component: ShoppingBagComponent;
  let fixture: ComponentFixture<ShoppingBagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoppingBagComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShoppingBagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
