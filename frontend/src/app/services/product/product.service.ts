import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Product } from "../../models/product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private http : HttpClient) { }

  public getAllProducts() : Observable<Array<Product>> {
    return this.http.get<Array<Product>>(`${this.apiServerUrl}/product`);
  }

  public getProduct(id : string) : Observable<Product> {
    return this.http.get<Product>(`${this.apiServerUrl}/product/${id}`);
  }
}
