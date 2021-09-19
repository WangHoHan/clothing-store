import { Component, OnDestroy, OnInit } from '@angular/core';
import { OrderService } from "../../services/order/order.service";
import { ShoppingBagProduct } from "../../models/shopping-bag-product";
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-shopping-bag',
  templateUrl: './shopping-bag.component.html',
  styleUrls: ['./shopping-bag.component.css']
})
export class ShoppingBagComponent implements OnInit, OnDestroy {

  shoppingBag : Array<ShoppingBagProduct> = [];

  constructor(private orderService : OrderService, private shoppingBagService : ShoppingBagService) { }

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

  public placeOrder() : void {
    this.orderService.placeOrder()
      .subscribe(
        (response : HttpResponse<any>) => {
        },
        (error : HttpErrorResponse) => {
          alert(error.message);
        }
      );
  }

  public removeProductFromShoppingBag(shoppingBagProduct : ShoppingBagProduct) : void {
    this.shoppingBagService.removeProductFromShoppingBag(shoppingBagProduct);
    this.shoppingBag = this.getShoppingBag();
  }
}
