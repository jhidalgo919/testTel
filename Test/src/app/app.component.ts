import { Component } from '@angular/core';
import { freeApiService } from './services/freeapi.service';
import { Post } from './classes/post';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Test';
  list_Posts: Post[] = [];
  product: Post = new Post();
  message:any;

  constructor(private _freeApiService: freeApiService){ }

  ngOnInit() {
    this._freeApiService.getPosts()
    .subscribe
    (
      data => {
        console.log(data);
        this.list_Posts = data;
      }
    );
    
  }

  public registerNow(){
    let resp = this._freeApiService.register(this.product);
    resp.subscribe(
      (data)=> {
        console.log(data);
        this.message = data;
      }
    )
  }

}
