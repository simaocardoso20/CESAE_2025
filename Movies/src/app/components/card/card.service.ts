import { Injectable } from '@angular/core';
import {Movie, MovieDetails, MoviesResponse} from '../../models/movie.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CardService {
  private domain: string = 'http://www.omdbapi.com';
  private apikey: string = 'e36eb539';

  /**
  private cards: Movie[] = [
    {
      Title: 'Movie Title 1',
      Year: '2023',
      imdbID: '123',
      Type: 'Type for Movie 1',
      Poster: 'https://m.media-amazon.com/images/I/81p6brsaWcL._UF894,1000_QL80_.jpg'
    }

  ];
    */

  constructor(private http: HttpClient) {}

  // devolve a lista de filmes
  getMovies(search: string): Observable<MoviesResponse> {
    return this.http.get<MoviesResponse>(`${this.domain}/?apikey=${this.apikey}&s=${search}`);
  }

  getMovieDetails(searchDetails:string):Observable<MovieDetails> {
    return this.http.get<MovieDetails>(`${this.domain}/?apikey=${this.apikey}&i=${searchDetails}`);
  }

  /**
  // adiciona um novo filme à lista
  addMovie(newMovie: Movie): void {
    this.cards.push(newMovie);
  }
    */
}
