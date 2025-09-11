import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {CarouselComponent} from './components/carousel/carousel.component';
import {CardComponent} from './components/card/card.component';
import {CardsComponent} from './components/cards/cards.component';
import {ViewNowButtonComponent} from './components/view-now-button/view-now-button.component';
import {FormContactComponent} from './components/form-contact/form-contact.component';
import {TextContactComponent} from './components/text-contact/text-contact.component';
import {TextGalleryComponent} from './components/text-gallery/text-gallery.component';
import {HeaderBlogComponent} from './components/header-blog/header-blog.component';
import {PostBlogComponent} from './components/post-blog/post-blog.component';
import {ArchivesBlogComponent} from './components/archives-blog/archives-blog.component';
import {GalleryCardsComponent} from './components/gallery-cards/gallery-cards.component';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, FooterComponent, CarouselComponent, CardComponent, CardsComponent,
    ViewNowButtonComponent, FormContactComponent, TextContactComponent, TextGalleryComponent, HeaderBlogComponent,
    PostBlogComponent, ArchivesBlogComponent, GalleryCardsComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'audi';
}
