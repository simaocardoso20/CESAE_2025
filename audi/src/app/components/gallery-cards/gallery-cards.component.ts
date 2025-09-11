import { Component } from '@angular/core';
import { GalleryCardComponent } from '../gallery-card/gallery-card.component';

@Component({
  selector: 'app-gallery-cards',
  standalone: true,
  templateUrl: './gallery-cards.component.html',
  imports: [GalleryCardComponent]
})
export class GalleryCardsComponent {
  cardImage1: string = 'https://images.unsplash.com/photo-1585684306031-83cefa838196?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8YXVkaXxlbnwwfDJ8MHx8fDI%3D';
  cardImage2: string = 'https://images.unsplash.com/photo-1585684313627-a1a73d6b0995?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8YXVkaXxlbnwwfDJ8MHx8fDI%3D';
  cardImage3: string = 'https://images.unsplash.com/photo-1631622198781-3de7ce11ccce?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGF1ZGl8ZW58MHwyfDB8fHwy';
  cardImage4: string = 'https://images.unsplash.com/photo-1462396881884-de2c07cb95ed?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8YXVkaXxlbnwwfDJ8MHx8fDA%3D';

  cardImage5: string = 'https://images.unsplash.com/photo-1672015763066-07676a7fba2f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTd8fGF1ZGl8ZW58MHwyfDB8fHww';
  cardImage6: string = 'https://images.unsplash.com/photo-1614196048524-f8ae4cfc0120?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjl8fGF1ZGl8ZW58MHwyfDB8fHww';
  cardImage7: string = 'https://images.unsplash.com/photo-1594987496089-4630a2a822e8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzR8fGF1ZGl8ZW58MHwyfDB8fHww';
  cardImage8: string = 'https://images.unsplash.com/photo-1682562614304-980ac3094b9a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fGF1ZGl8ZW58MHwyfDB8fHww';
}


