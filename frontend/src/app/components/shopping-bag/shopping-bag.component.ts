import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-shopping-bag',
  templateUrl: './shopping-bag.component.html',
  styleUrls: ['./shopping-bag.component.css']
})
export class ShoppingBagComponent implements OnInit, OnDestroy{

  constructor() { }

  ngOnInit() : void {
    document.body.style.backgroundColor="lightyellow";
  }

  ngOnDestroy() : void {
    document.body.style.backgroundColor="unset";
  }
}
