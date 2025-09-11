import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivesBlogComponent } from './archives-blog.component';

describe('ArchivesBlogComponent', () => {
  let component: ArchivesBlogComponent;
  let fixture: ComponentFixture<ArchivesBlogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArchivesBlogComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArchivesBlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
