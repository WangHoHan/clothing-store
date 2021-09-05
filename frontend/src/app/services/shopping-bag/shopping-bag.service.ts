import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../../models/product";

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
    if (localStorage.getItem("shoppingBag") != null) {
      this._shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
    }
    this._shoppingBag.push(value);
    localStorage.setItem("shoppingBag", JSON.stringify(this._shoppingBag));
  }

  public getShoppingBag() {
    if (localStorage.getItem("shoppingBag") != null) {
      this._shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
    }
    return this._shoppingBag;
  }
}
