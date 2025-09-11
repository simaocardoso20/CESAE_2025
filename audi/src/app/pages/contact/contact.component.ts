import { Component } from '@angular/core';
import {FormContactComponent} from '../../components/form-contact/form-contact.component';
import {TextContactComponent} from '../../components/text-contact/text-contact.component';

@Component({
  selector: 'app-contact',
  imports: [
    FormContactComponent,
    TextContactComponent
  ],
  templateUrl: './contact.component.html',
  styleUrl: './contact.component.scss'
})
export class ContactComponent {

}
