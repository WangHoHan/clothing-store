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

  public getNumberOfProductsInShoppingBag() : number {
    let numberOfProductsInShoppingBag : number = 0;
    if (localStorage.getItem("shoppingBag") != null) {
      this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
      this.shoppingBag.forEach(elem => {
        numberOfProductsInShoppingBag = numberOfProductsInShoppingBag + elem.quantity;
      });
    }
    return numberOfProductsInShoppingBag;
  }

  public getShippingFee() : number {
    let shippingFee : number = 0;
    return shippingFee;
  }

  public getShoppingBag() : Array<ShoppingBagProduct> {
    if (localStorage.getItem("shoppingBag") != null) {
      this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
    }
    return this.shoppingBag;
  }

  public getSubTotal() : number {
    let subTotal : number = 0;
    if (localStorage.getItem("shoppingBag") != null) {
      this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
      this.shoppingBag.forEach(elem => {
        subTotal = subTotal + elem.product.price * elem.quantity;
      });
    }
    return subTotal;
  }

  public getTotal() : number {
    return this.getSubTotal() + this.getShippingFee();
  }

  public removeProductFromShoppingBag(shoppingBagProduct : ShoppingBagProduct) : void {
    if (localStorage.getItem("shoppingBag") != null) {
      this.shoppingBag = JSON.parse(<string>localStorage.getItem("shoppingBag"));
      this.shoppingBag = this.shoppingBag.filter(elem => (elem.product.id !== shoppingBagProduct.product.id ||
      elem.size !== shoppingBagProduct.size));
      localStorage.setItem("shoppingBag", JSON.stringify(this.shoppingBag));
    }
  }
}
