import {Component, Input} from '@angular/core';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {OrderFulfillment} from "../../model/order-fulfillment";
import {MedicationViewComponent} from "../medication-view/medication-view.component";

@Component({
  selector: 'app-fulfillment-view',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, MatIconModule, MedicationViewComponent],
  templateUrl: './fulfillment-view.component.html',
  styleUrl: './fulfillment-view.component.scss',
  animations: [
    trigger('detailExpand', [
      state('collapsed,void', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ])
  ]
})

export class FulfillmentViewComponent {
  displayedColumns: string[] = ['id', 'droneId', 'timestamp', 'status'];
  @Input() dataSource: OrderFulfillment[] = [];
  captions: Map<string, string> = new Map<string, string> ([
    ['id', 'ID'],
    ['droneId', 'Drone'],
    ['timestamp', 'Creation Time'],
    ['status', 'Status']
  ]);
  expandedElement: OrderFulfillment | null | undefined;
  columnsToDisplayWithExpand = [...this.displayedColumns, 'expand'];
}
