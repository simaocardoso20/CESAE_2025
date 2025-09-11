import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextGalleryComponent } from './text-gallery.component';

describe('TextGalleryComponent', () => {
  let component: TextGalleryComponent;
  let fixture: ComponentFixture<TextGalleryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TextGalleryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TextGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
