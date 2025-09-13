import { Component } from '@angular/core';
import { CardMovieComponent } from '../card-movie/card-movie.component';
import { NgForOf } from '@angular/common';
import {Movie} from '../../models/movie.model';


@Component({
  selector: 'app-cards-movie',
  imports: [
    CardMovieComponent,
    NgForOf
  ],
  templateUrl: './cards-movie.component.html',
  styleUrls: ['./cards-movie.component.scss']
})
export class CardsMovieComponent {

  cards: Movie[] = [
    {
      id: 1,
      year: '2021',
      title: 'Dune',
      description: 'A young nobleman is caught in a battle for control of a powerful resource that can unlock humanity’s true potential.',
      poster: 'https://m.media-amazon.com/images/I/81p6brsaWcL._UF894,1000_QL80_.jpg'
    },
    {
      id: 2,
      year: '2019',
      title: 'Joker',
      description: 'A failed comedian in Gotham spirals into chaos, giving birth to the infamous villain, the Joker.',
      poster: 'https://m.media-amazon.com/images/I/81V0EHAIX+L._UF894,1000_QL80_.jpg'
    },
    {
      id: 3,
      year: '1976',
      title: 'Rocky',
      description: 'Rocky Balboa, a struggling boxer, gets a chance to fight for the world title against Apollo Creed, aiming to prove his worth.',
      poster: 'https://m.media-amazon.com/images/I/81VIIY+2heL.jpg'
    },
    {
      id: 4,
      year: '2015',
      title: 'Mad Max: Fury Road',
      description: 'In a post-apocalyptic wasteland, Max teams up with a mysterious woman to escape a tyrannical warlord and his army of warboys.',
      poster: 'https://m.media-amazon.com/images/I/715dDARDrGL.jpg'
    },
    {
      id: 5,
      year: '2019',
      title: 'Once Upon a Time in Hollywood',
      description: 'A faded television actor and his stunt double strive to achieve fame and success in the final years of Hollywood\'s Golden Age in 1969 Los Angeles.',
      poster: 'https://m.media-amazon.com/images/I/71noeakTYLL._AC_SY679_.jpg'
    },
    {
      id: 6,
      year: '2020',
      title: 'Tenet',
      description: 'Armed with only one word—Tenet—and fighting for the survival of the world, a protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.',
      poster: 'https://m.media-amazon.com/images/I/91w1zD5TbML._AC_SY679_.jpg'
    },
    {
      id: 7,
      year: '2018',
      title: 'Avengers: Infinity War',
      description: 'The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of destruction and ruin puts an end to the universe.',
      poster: 'https://m.media-amazon.com/images/I/81V4eT51f+L._AC_SY679_.jpg'
    },
    {
      id: 8,
      year: '2021',
      title: 'No Time to Die',
      description: 'James Bond has left active service. His peace is short-lived when Felix Leiter from the CIA turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.',
      poster: 'https://m.media-amazon.com/images/I/91zHhFCAmLL._AC_SY679_.jpg'
    },
    {
      id: 9,
      year: '2018',
      title: 'Black Panther',
      description: 'T\'Challa, the king of Wakanda, must step forward to lead his people into a new future and face the challenges brought by a villain from his past.',
      poster: 'https://m.media-amazon.com/images/I/91zF5eZ6FsL._AC_SY679_.jpg'
    },
    {
      id: 10,
      year: '2016',
      title: 'La La Land',
      description: 'A jazz musician and an aspiring actress fall in love, but their ambitions lead them in different directions as they struggle to balance love and career in a modern-day Los Angeles.',
      poster: 'https://m.media-amazon.com/images/I/91Wl+BXVowL._AC_SY679_.jpg'
    }
  ];

}
