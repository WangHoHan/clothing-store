import { PurchaseContent } from "./purchase-content";
import { ShippingInfo } from "./shipping-info";

export class Purchase {
  shippingMethod : string;
  paymentMethod : string;
  shippingInfo : ShippingInfo;
  orderContentList : Array<PurchaseContent>;

  constructor(shippingMethod : string, paymentMethod : string, shippingInfo : ShippingInfo,
              orderContentList : Array<PurchaseContent>) {
    this.shippingMethod = shippingMethod;
    this.paymentMethod = paymentMethod;
    this.shippingInfo = shippingInfo;
    this.orderContentList = orderContentList;
  }
}
