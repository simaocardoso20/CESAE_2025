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
  cardDescription: string = 'Card Description 1';
  cardImage: string='https://s2-autoesporte.glbimg.com/9wt5cyg2nlJEQKLk0gOgm1xI77M=/0x0:1600x1001/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2023/0/l/epmEHiRNybw2xroTwsqQ/110-audi-r8-coupe-japan-final-edition-001-l.jpg';
}
