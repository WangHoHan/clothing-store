import { Order } from "./order";
import { User } from "./user";

export class ShippingInfo {
  id : number;
  firstName : string;
  lastName : string;
  line1 : string;
  line2 : string;
  postalCode : string;
  city : string;
  phoneNumber : string;
  user : User;
  orders : Array<Order>;

  constructor(id : number, firstName : string, lastName : string, line1 : string, line2 : string, postalCode : string,
              city : string, phoneNumber : string, user : User, orders : Array<Order>) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.line1 = line1;
    this.line2 = line2;
    this.postalCode = postalCode;
    this.city = city;
    this.phoneNumber = phoneNumber;
    this.user = user;
    this.orders = orders;
  }
}
