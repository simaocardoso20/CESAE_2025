import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-gallery-card',
  standalone: true,
  templateUrl: './gallery-card.component.html',
  styleUrls: ['./gallery-card.component.scss']
})
export class GalleryCardComponent {
  @Input() image: string = '';
  @Input() title: string = '';
}

