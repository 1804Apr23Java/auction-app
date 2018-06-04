import { Injectable } from '@angular/core';
import {Http,Response,Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs';

import { map } from 'rxjs/operators';

import { User } from '../user';




@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private baseUrl:string ='http://localhost:8080/AuctionSite/user/';
  private headers = new Headers({'content-Type': 'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private http: Http) { 
    console.log("const ran for the services")
  }
  getUser(user:User):Observable<Object>{
    console.log("shivam");
    return this.http.get(this.baseUrl+'login',this.options).pipe(map((response:Response) => response.json()));
  }
  errorHandler(error :Response){
    return Observable.throw(error || "serverError");
  }
}
