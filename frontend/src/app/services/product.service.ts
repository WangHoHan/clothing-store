import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  public getProducts() : Observable<any> {
    return this.http.get<any>(`${this.apiServerUrl}/product`)
  }
}
