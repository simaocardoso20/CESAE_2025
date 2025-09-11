import { Component } from '@angular/core';
import {HeaderBlogComponent} from '../../components/header-blog/header-blog.component';
import {PostBlogComponent} from '../../components/post-blog/post-blog.component';
import {ArchivesBlogComponent} from '../../components/archives-blog/archives-blog.component';

@Component({
  selector: 'app-blog',
  imports: [
    HeaderBlogComponent,
    PostBlogComponent,
    ArchivesBlogComponent
  ],
  templateUrl: './blog.component.html',
  styleUrl: './blog.component.scss'
})
export class BlogComponent {

}
