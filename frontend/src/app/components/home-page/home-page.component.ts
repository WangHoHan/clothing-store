import { Component, OnInit } from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http";
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public products : Array<Product> = [];

  constructor(private productService : ProductService) { }

  public getProducts() : void {
    this.productService.getProducts().subscribe(
      (response : Array<Product>) => {
        this.products = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  ngOnInit(): void {
    this.getProducts();
  }

}
