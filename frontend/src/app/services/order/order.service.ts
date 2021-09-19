import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Purchase } from "../../models/purchase";
import { PurchaseContent } from "../../models/purchase-content";
import { ShippingInfo } from "../../models/shipping-info";
import { ShoppingBagProduct } from "../../models/shopping-bag-product";
import { ShoppingBagService } from "../shopping-bag/shopping-bag.service";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiServerUrl = 'http://localhost:8080';

  constructor(private http : HttpClient, private shoppingBagService : ShoppingBagService) { }

  public placeOrder() : Observable<HttpResponse<any>> {
    let shippingInfo : ShippingInfo = new ShippingInfo("Jan", "Kowalski", "ul. Słoneczna 1",
      "", "00-000", "Warszawa", "+48 123 456 789");
    let shoppingBag : Array<ShoppingBagProduct> = this.shoppingBagService.getShoppingBag();
    let orderContentList : Array<PurchaseContent> = [];
    shoppingBag.forEach(elem => orderContentList.push(new PurchaseContent(elem.product.id, elem.size, elem.quantity)));
    let purchase : Purchase = new Purchase("parcel locker", "credit card payment",
      shippingInfo, orderContentList);
    return this.http.post<any>(`${this.apiServerUrl}/order`, purchase);
  }
}
