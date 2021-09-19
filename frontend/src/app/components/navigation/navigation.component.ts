import { Component, OnInit } from '@angular/core';
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private shoppingBagService : ShoppingBagService) { }

  ngOnInit() : void {
    this.updateMousePosition();
  }

  public updateMousePosition() : void {
    window.addEventListener("mousemove", function (event) {
      // @ts-ignore
      document.getElementById("mouse-x-position").textContent = event.x;
      // @ts-ignore
      document.getElementById("mouse-y-position").textContent = event.y;
    });
  }

  public getNumberOfProductsInShoppingBag() : number {
    return this.shoppingBagService.getNumberOfProductsInShoppingBag();
  }
}
