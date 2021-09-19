import { Component, OnInit } from '@angular/core';
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private shoppingBagService : ShoppingBagService) { }

  ngOnInit() : void { }

  public getNumberOfProductsInShoppingBag() : number {
    return this.shoppingBagService.getNumberOfProductsInShoppingBag();
  }
}
