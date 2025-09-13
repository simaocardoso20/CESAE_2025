import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageHomeComponent } from './image-home.component';

describe('ImageHomeComponent', () => {
  let component: ImageHomeComponent;
  let fixture: ComponentFixture<ImageHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageHomeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImageHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
