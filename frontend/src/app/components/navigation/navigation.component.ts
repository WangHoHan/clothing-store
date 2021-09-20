import { Component, OnInit } from '@angular/core';
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  public hour! : string;
  public minute! : string;
  public amPm! : string;

  constructor(private shoppingBagService : ShoppingBagService) { }

  ngOnInit() : void {
    setInterval(() => {
      let date : Date = new Date(Date.now());
      let hourAmPm : string = new Intl.DateTimeFormat('en', { hour: '2-digit' }).format(date);
      this.hour = hourAmPm.split(" ")[0];
      this.hour = hourAmPm.split(" ")[0];
      this.minute = new Intl.DateTimeFormat('en', { minute: '2-digit' }).format(date);
      this.amPm = hourAmPm.split(" ")[1];
    }, 1000);
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
