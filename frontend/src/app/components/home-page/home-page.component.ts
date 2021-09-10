import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from "@angular/common/http";
import { Product } from "../../models/product";
import { ProductService } from "../../services/product/product.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public products : Array<Product> = [];

  constructor(private productService : ProductService) { }

  ngOnInit() : void {
    this.getAllProducts();
  }

  public getAllProducts() : void {
    this.productService.getAllProducts().subscribe(
      (response : Array<Product>) => {
        this.products = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
