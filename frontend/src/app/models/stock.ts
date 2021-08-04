import {Product} from "./product";

export class Stock {
  id : number;
  sizeTag : string;
  measurements : string;
  quantity : number;
  product : Product;

  constructor(id : number, sizeTag : string, measurements : string, quantity : number, product : Product) {
    this.id = id;
    this.sizeTag = sizeTag;
    this.measurements = measurements;
    this.quantity = quantity;
    this.product = product;
  }
}
