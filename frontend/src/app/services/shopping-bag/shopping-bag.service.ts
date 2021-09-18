import { Injectable } from '@angular/core';
import { Product } from "../../models/product";
import { ShoppingBagProduct } from "../../models/shopping-bag-product";

@Injectable({
  providedIn: 'root'
})
export class ShoppingBagService {

  private shoppingBag : Array<ShoppingBagProduct> = [];

  constructor() { }

  public addProductToShoppingBag(product : Product, size : string) : void {
    if (localStorage.getItem("shoppingBag") != null) {
      this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
    }
    let productIndex = this.shoppingBag.findIndex(element => element.product.id == product.id && element.size == size);
    if (productIndex != -1) {
      this.shoppingBag[productIndex].quantity = this.shoppingBag[productIndex].quantity + 1;
    }
    else {
      let shoppingBagProduct : ShoppingBagProduct = new ShoppingBagProduct(product, size, 1);
      this.shoppingBag.push(shoppingBagProduct);
    }
    localStorage.setItem("shoppingBag", JSON.stringify(this.shoppingBag));
  }

  public getShoppingBag() : Array<ShoppingBagProduct> {
    this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
    return this.shoppingBag;
  }
}
