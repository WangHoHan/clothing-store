export class PurchaseContent {
  productId : number;
  size : string;
  quantity : number;

  constructor(productId : number, size : string, quantity : number) {
    this.productId = productId;
    this.size = size;
    this.quantity = quantity;
  }
}
