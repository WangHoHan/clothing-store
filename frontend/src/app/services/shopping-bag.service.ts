import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/product";

@Injectable({
  providedIn: 'root'
})
export class ShoppingBagService {

  private apiServerUrl = 'http://localhost:8080';

  private _shoppingBag : Array<Product> = [];

  constructor(private http : HttpClient) { }

  get shoppingBag(): Array<Product> {
    return this._shoppingBag;
  }

  set shoppingBag(value: Array<Product>) {
    this._shoppingBag = value;
  }

  public addProductToShoppingBag(value: Product) : void {
    this._shoppingBag.push(value);
  }

  public getShoppingBag() {
    return this._shoppingBag;
  }
}
