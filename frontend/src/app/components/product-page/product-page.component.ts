import { ActivatedRoute } from "@angular/router";
import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from "@angular/common/http";
import { Product } from "../../models/product";
import { ProductService } from "../../services/product/product.service";
import { ShoppingBagService } from "../../services/shopping-bag/shopping-bag.service";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  public product! : Product;

  constructor(private route: ActivatedRoute, private productService : ProductService,
              private shoppingBagService : ShoppingBagService) { }

  ngOnInit() : void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id != null) {
      this.getProduct(id);
    }
  }

  public addProductToShoppingBag(product : Product, productInfo : any) : void {
    this.shoppingBagService.addProductToShoppingBag(product, productInfo.size);
  }

  public getProduct(id : string) : void {
    this.productService.getProduct(id)
      .subscribe(
      (response : Product) => {
        this.product = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
