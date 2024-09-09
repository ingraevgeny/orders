import {Component, OnInit} from '@angular/core';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {OrderService} from "../../service/order.service";
import {Order} from "../../model/order";
import {FulfillmentViewComponent} from "../fulfillment-view/fulfillment-view.component";

@Component({
  selector: 'app-orders-view',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, MatIconModule, FulfillmentViewComponent],
  templateUrl: './orders-view.component.html',
  styleUrl: './orders-view.component.scss',
  animations: [
    trigger('detailExpand', [
      state('collapsed,void', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class OrdersViewComponent implements OnInit  {
  displayedColumns: string[] = ['id', 'clientId', 'timestamp'];
  captions: Map<string, string> = new Map<string, string> ([
    ['id', 'ID'],
    ['clientId', 'Client ID'],
    ['timestamp', 'Creation Time']
  ]);
  dataSource: Order[] = [];
  expandedElement: Order | null | undefined;
  columnsToDisplayWithExpand = [...this.displayedColumns, 'expand'];

  constructor(private orderService : OrderService) {
  }

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.orderService.getAllOrders()
        .subscribe(data => this.dataSource = data);
  }
}
