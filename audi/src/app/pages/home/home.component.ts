import { Component } from '@angular/core';
import {CardsComponent} from '../../components/cards/cards.component';
import {CarouselComponent} from '../../components/carousel/carousel.component';

@Component({
  selector: 'app-home',
  imports: [
    CardsComponent,
    CarouselComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
