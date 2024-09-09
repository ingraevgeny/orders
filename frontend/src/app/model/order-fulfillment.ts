import {Status} from "../dict/status";
import {Medication} from "./medication";

export interface OrderFulfillment {
  id: number;
  timestamp: string;
  status: Status;
  droneId: number;
  medications: Medication[];
}
