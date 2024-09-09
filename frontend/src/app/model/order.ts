import {OrderFulfillment} from "./order-fulfillment";

export interface Order {
  id: number;
  clientId: number;
  timestamp: string;
  orderFulfillment: OrderFulfillment[];
}
