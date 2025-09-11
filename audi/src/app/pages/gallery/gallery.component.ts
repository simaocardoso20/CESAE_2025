import { Component } from '@angular/core';
import {MdbRippleModule} from "mdb-angular-ui-kit/ripple";
import {ViewNowButtonComponent} from '../../components/view-now-button/view-now-button.component';
import {GalleryCardsComponent} from '../../components/gallery-cards/gallery-cards.component';
import {TextGalleryComponent} from '../../components/text-gallery/text-gallery.component';

@Component({
  selector: 'app-gallery',
  imports: [
    MdbRippleModule,
    ViewNowButtonComponent,
    GalleryCardsComponent,
    TextGalleryComponent
  ],
  templateUrl: './gallery.component.html',
  styleUrl: './gallery.component.scss'
})
export class GalleryComponent {

}
