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
    this.shoppingBag = this.shoppingBagService.getShoppingBag();
  }

  ngOnDestroy() : void {
    document.body.style.backgroundColor="unset";
  }
}
