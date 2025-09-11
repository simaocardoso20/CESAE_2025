import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {CarouselComponent} from './components/carousel/carousel.component';
import {CardComponent} from './components/card/card.component';
import {CardsComponent} from './components/cards/cards.component';
import {ViewNowButtonComponent} from './components/view-now-button/view-now-button.component';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, FooterComponent, CarouselComponent, CardComponent, CardsComponent, ViewNowButtonComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'audi';
}
