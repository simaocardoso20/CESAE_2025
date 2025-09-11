import {Component, Input, input} from '@angular/core';
import {MdbRippleModule} from 'mdb-angular-ui-kit/ripple';

@Component({
  selector: 'app-view-now-button',
  imports: [
    MdbRippleModule
  ],
  templateUrl: './view-now-button.component.html',
  styleUrl: './view-now-button.component.scss'
})
export class ViewNowButtonComponent {
@Input() text: string = 'View now';
}
