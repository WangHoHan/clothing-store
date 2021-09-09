import { Component, OnDestroy, OnInit } from '@angular/core';
import { Product } from "../../models/product";
import { OrderService } from "../../services/order/order.service";

@Component({
  selector: 'app-shopping-bag',
  templateUrl: './shopping-bag.component.html',
  styleUrls: ['./shopping-bag.component.css']
})
export class ShoppingBagComponent implements OnInit, OnDestroy{

  public shoppingBag : Array<Product> = [];

  constructor(private shoppingBagService : OrderService) { }

  public getShoppingBag() : void {
    this.shoppingBag = this.shoppingBagService.getShoppingBag();
  }

  ngOnInit(): void {
    document.body.style.backgroundColor="lightyellow";
    this.getShoppingBag();
  }

  ngOnDestroy() {
    document.body.style.backgroundColor="unset";
  }
}
