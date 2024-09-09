import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Order} from "../model/order";

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  getOrdersByClientUrl = "/orders/getOrdersByClient";
  getAllOrdersUrl = "/orders/getAllOrders";

  constructor(private http: HttpClient) { }

  getClientOrders(clientId: number) {
    return this.http.get<Order[]>(this.getOrdersByClientUrl, { params: { clientId } });
  }

  getAllOrders() {
    return this.http.get<Order[]>(this.getAllOrdersUrl);
  }
}
