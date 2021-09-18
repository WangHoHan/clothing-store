import { Product } from "./product";

export class ShoppingBagProduct {
  product : Product;
  size : string;
  quantity : number;

  constructor(product : Product, size : string, quantity : number) {
    this.product = product;
    this.size = size;
    this.quantity = quantity;
  }
}
