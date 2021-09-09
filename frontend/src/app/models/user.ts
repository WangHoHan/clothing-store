import { Order } from "./order";
import { ShippingInfo } from "./shipping-info";

export class User {
  id : number;
  email : string;
  password : string;
  firstName : string;
  lastName : string;
  phoneNumber : string;
  accountType : string;
  shippingInfoList : Array<ShippingInfo>;
  orders : Array<Order>;

  constructor(id : number, email : string, password : string, firstName : string, lastName : string,
              phoneNumber : string, accountType : string, shippingInfoList : Array<ShippingInfo>,  orders : Array<Order>) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.accountType = accountType;
    this.shippingInfoList = shippingInfoList;
    this.orders = orders;
  }
}
