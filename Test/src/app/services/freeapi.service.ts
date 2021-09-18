import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Post } from "../classes/post";

@Injectable()
export class freeApiService {

    constructor(private httpClient: HttpClient){ }

    getPosts(): Observable<any> {
        return this.httpClient.get("http://localhost:8080/productos/list");
    }

    public deletePost(id: any){
        return this.httpClient.delete("http://localhost:8080/posts/delete/"+id);

    }

    public register(post:any) {
        return this.httpClient.post("http://localhost:8080/posts/add", post, {responseType:'text' as 'json'});
    }
}