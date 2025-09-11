import { Component } from '@angular/core';

@Component({
  selector: 'app-gallery-cards',
  templateUrl: './gallery-cards.component.html',
  // styleUrls: ['./gallery-cards.component.css']
})
export class GalleryCardsComponent {
  // Array com URLs das imagens
  images: string[] = [
    'https://picsum.photos/300/300?random=1',
    'https://picsum.photos/300/300?random=2',
    'https://picsum.photos/300/300?random=3',
    'https://picsum.photos/300/300?random=4',
    'https://picsum.photos/300/300?random=5',
    'https://picsum.photos/300/300?random=6',
    'https://picsum.photos/300/300?random=7',
    'https://picsum.photos/300/300?random=8'
  ];
}

