import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewNowButtonComponent } from './view-now-button.component';

describe('ViewNowButtonComponent', () => {
  let component: ViewNowButtonComponent;
  let fixture: ComponentFixture<ViewNowButtonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewNowButtonComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewNowButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
