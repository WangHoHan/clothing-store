import { Order } from "./order";
import {Product} from "./product";

export class OrderContent {
  id : number;
  order : Order;
  product : Product;
  size : string;
  quantity : number;

  constructor(id : number, order : Order, product : Product, size : string, quantity : number) {
    this.id = id;
    this.order = order;
    this.product = product;
    this.size = size;
    this.quantity = quantity;
  }
}
