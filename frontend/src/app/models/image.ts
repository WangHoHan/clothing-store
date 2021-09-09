import { ProductInfo } from "./product-info";

export class Image {
  id : number;
  file : string;
  name : string;
  productInfo : ProductInfo;

  constructor(id : number, file : string, name : string, productInfo : ProductInfo) {
    this.id = id;
    this.file = file;
    this.name = name;
    this.productInfo = productInfo;
  }
}
