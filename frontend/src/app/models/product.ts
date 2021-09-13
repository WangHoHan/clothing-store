import { Category } from "./category";
import { ProductInfo } from "./product-info";
import { Stock } from "./stock";

export class Product {
  id : number;
  name : string;
  description : string;
  gender: string;
  price : number;
  discount : number;
  createdAt : Date;
  updatedAt : Date;
  productInfo : ProductInfo;
  stock : Array<Stock>;
  category : Set<Category>;

  constructor(id : number, name : string, description : string, gender : string, price : number, discount : number,
              createdAt : Date, updatedAt : Date, productInfo : ProductInfo, stock : Array<Stock>,
              category : Set<Category>) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.gender = gender;
    this.price = price;
    this.discount = discount;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.productInfo = productInfo;
    this.stock = stock;
    this.category = category;
  }
}
