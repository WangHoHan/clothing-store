import {OrderContent} from "./order-content";
import {ShippingInfo} from "./shipping-info";
import {User} from "./user";

export class Order {
  id : number;
  state : string;
  tracking : string;
  shippingMethod : string;
  paymentMethod : string;
  total : number;
  paid : boolean;
  user : User;
  shippingInfo : ShippingInfo;
  orderContentList : Array<OrderContent>;

  constructor(id : number, state : string, tracking : string, shippingMethod : string, paymentMethod : string,
              total : number, paid : boolean, user : User, shippingInfo : ShippingInfo, orderContentList : Array<OrderContent>) {
    this.id = id;
    this.state = state;
    this.tracking = tracking;
    this.shippingMethod = shippingMethod;
    this.paymentMethod = paymentMethod;
    this.total = total;
    this.paid = paid;
    this.user = user;
    this.shippingInfo = shippingInfo;
    this.orderContentList = orderContentList;
  }
}
