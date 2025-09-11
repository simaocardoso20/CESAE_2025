import { Component } from '@angular/core';
import {MdbRippleModule} from 'mdb-angular-ui-kit/ripple';

@Component({
  selector: 'app-about',
  imports: [
    MdbRippleModule
  ],
  templateUrl: './about.component.html',
  styleUrl: './about.component.scss'
})
export class AboutComponent {

}
