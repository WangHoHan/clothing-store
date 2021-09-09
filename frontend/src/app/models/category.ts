import { Product } from "./product";

export class Category {
  id : number;
  name : string;
  subCategory : string;
  products : Set<Product>;

  constructor(id : number, name : string, subCategory : string, products : Set<Product>) {
    this.id = id;
    this.name = name;
    this.subCategory = subCategory;
    this.products = products;
  }
}
