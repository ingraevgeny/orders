import {Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {OrdersViewComponent} from "./components/orders-view/orders-view.component";
import {FulfillmentViewComponent} from "./components/fulfillment-view/fulfillment-view.component";

@Component({
  selector: 'app-root',
  standalone: true,
    imports: [RouterOutlet, OrdersViewComponent, FulfillmentViewComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

}
