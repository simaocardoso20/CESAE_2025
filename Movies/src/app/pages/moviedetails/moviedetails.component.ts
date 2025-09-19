import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {MdbFormsModule} from "mdb-angular-ui-kit/forms";
import {MdbRippleModule} from "mdb-angular-ui-kit/ripple";
import {CardService} from '../../components/card/card.service';
import {MovieDetails} from '../../models/movie.model';
import {NgIf} from '@angular/common';

@Component({
  selector: 'app-moviedetails',
  standalone: true,
  imports: [
    FormsModule,
    MdbFormsModule,
    MdbRippleModule,
    NgIf
  ],
  templateUrl: './moviedetails.component.html',
  styleUrls: ['./moviedetails.component.scss']
})
export class MovieDetailsComponent implements OnInit {
  searchDetails: string = '';
  movieDetails: MovieDetails = {
    Title: '',
    Year: '',
    Rated: '',
    Released: '',
    Runtime: '',
    Genre: '',
    Director: '',
    Writer: '',
    Actors: '',
    Plot: '',
    Language: '',
    Country: '',
    Awards: '',
    Poster: '',
    Ratings: [],
    Metascore: '',
    imdbRating: '',
    imdbVotes: '',
    imdbID: '',
    Type: '',
    DVD: '',
    BoxOffice: '',
    Production: '',
    Website: '',
    Response: '',
  };

  constructor(private cardService: CardService) {
  }

  ngOnInit(): void {
  }

  getMovieDetails(): void {
    this.cardService.getMovieDetails(this.searchDetails).subscribe(
      (movieDetails: MovieDetails) => {
        this.movieDetails = movieDetails;
      }
    );
  }
}

