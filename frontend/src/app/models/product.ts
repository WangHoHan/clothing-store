import {Category} from "./category";
import {ProductInfo} from "./product-info";
import {Size} from "./size";

export class Product {
  id : number;
  name : string;
  description : string;
  gender: string;
  price : number;
  discount : number;
  productInfo : ProductInfo;
  sizes : Array<Size>;
  category : Set<Category>;

  constructor(id : number, name : string, description : string, gender : string, price : number, discount : number,
              productInfo : ProductInfo, sizes : Array<Size>, category : Set<Category>) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.gender = gender;
    this.price = price;
    this.discount = discount;
    this.productInfo = productInfo;
    this.sizes = sizes;
    this.category = category;
  }
}
