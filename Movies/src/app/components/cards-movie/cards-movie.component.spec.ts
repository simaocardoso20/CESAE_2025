import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsMovieComponent } from './cards-movie.component';

describe('CardsMovieComponent', () => {
  let component: CardsMovieComponent;
  let fixture: ComponentFixture<CardsMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CardsMovieComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardsMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
