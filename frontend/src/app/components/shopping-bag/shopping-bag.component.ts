import { Component, OnDestroy, OnInit } from '@angular/core';
import { ShoppingBagProduct } from "../../models/shopping-bag-product";
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";

@Component({
  selector: 'app-shopping-bag',
  templateUrl: './shopping-bag.component.html',
  styleUrls: ['./shopping-bag.component.css']
})
export class ShoppingBagComponent implements OnInit, OnDestroy {

  shoppingBag : Array<ShoppingBagProduct> = [];

  constructor(private shoppingBagService : ShoppingBagService) { }

  ngOnInit() : void {
    document.body.style.backgroundColor="lightyellow";
    this.shoppingBag = this.getShoppingBag();
  }

  ngOnDestroy() : void {
    document.body.style.backgroundColor="unset";
  }

  public getNumberOfProductsInShoppingBag() : number {
    return this.shoppingBagService.getNumberOfProductsInShoppingBag();
}

public getShippingFee() : number {
    return this.shoppingBagService.getShippingFee();
}

public getShoppingBag() : Array<ShoppingBagProduct> {
  return this.shoppingBagService.getShoppingBag();
}

  public getSubTotal() : number {
    return this.shoppingBagService.getSubTotal();
  }

  public getTotal() : number {
    return this.shoppingBagService.getTotal();
  }

  public removeProductFromShoppingBag(shoppingBagProduct : ShoppingBagProduct) : void {
    this.shoppingBagService.removeProductFromShoppingBag(shoppingBagProduct);
    this.shoppingBag = this.getShoppingBag();
  }
}
