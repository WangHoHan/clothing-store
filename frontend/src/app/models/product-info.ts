import { Image } from "./image";
import { Product } from "./product";

export class ProductInfo {
  id : number;
  color : string;
  fabrics : string;
  images : Array<Image>;
  modelSize : string;
  modelHeight : string;
  modelWeight : string;
  product : Product;

  constructor(id : number, color : string, fabrics : string, images : Array<Image>, modelSize : string,
              modelHeight : string, modelWeight : string, product : Product) {
    this.id = id;
    this.color = color;
    this.fabrics = fabrics;
    this.images = images;
    this.modelSize = modelSize;
    this.modelHeight = modelHeight;
    this.modelWeight = modelWeight;
    this.product = product;
  }
}
