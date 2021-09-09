import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { HttpErrorResponse } from "@angular/common/http";
import { Product } from "../../models/product";
import { ProductService } from "../../services/product/product.service";
import { OrderService } from "../../services/order/order.service";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  public product! : Product;

  constructor(private route: ActivatedRoute, private productService : ProductService, private shoppingBagSerive : OrderService) { }

  public getProduct(id : string) : void {
    this.productService.getProduct(id).subscribe(
      (response : Product) => {
        this.product = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public addProductToShoppingBag() {
    this.shoppingBagSerive.addProductToShoppingBag(this.product);
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.getProduct(id!);
  }
}
