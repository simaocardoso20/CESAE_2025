import { Component } from '@angular/core';
import {CardComponent} from '../card/card.component';


@Component({
  selector: 'app-cards',
  imports: [CardComponent],
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.scss'

})
export class CardsComponent {
  cardTitle: string = 'Audi R8';
  cardDescription: string = '620 hp sent to the rear wheels is just part of the farewell worthy of a true legend.';
  cardImage: string = 'https://images.pistonheads.com/nimg/46501/mceu_10418411921669210684869.jpg';

  cardTitle2: string = 'Coupé V10';
  cardDescription2: string = 'A perfect combination of power, precision, and design.';
  cardImage2: string = 'https://images.pistonheads.com/nimg/46501/mceu_81961402981669210807620.jpg';

  cardTitle3: string = 'GT RWD';
  cardDescription3: string = 'Luxury meets speed and every day becomes an unforgettable experience.';
  cardImage3: string = 'https://images.pistonheads.com/nimg/46501/mceu_36961854261669210762610.jpg';
}
