import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FulfillmentViewComponent } from './fulfillment-view.component';

describe('FulfillmentViewComponent', () => {
  let component: FulfillmentViewComponent;
  let fixture: ComponentFixture<FulfillmentViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FulfillmentViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FulfillmentViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
