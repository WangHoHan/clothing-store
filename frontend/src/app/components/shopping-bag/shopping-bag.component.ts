import {Component, OnDestroy, OnInit} from '@angular/core';
import {ShoppingBagService} from "../../services/shopping-bag/shopping-bag.service";
import {Product} from "../../models/product";

@Component({
  selector: 'app-shopping-bag',
  templateUrl: './shopping-bag.component.html',
  styleUrls: ['./shopping-bag.component.css']
})
export class ShoppingBagComponent implements OnInit, OnDestroy{

  public shoppingBag : Array<Product> = [];

  constructor(private shoppingBagService : ShoppingBagService) { }

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
