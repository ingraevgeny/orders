import {Component, Input} from '@angular/core';
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {Medication} from "../../model/medication";

@Component({
  selector: 'app-medication-view',
  standalone: true,
  imports: [MatTableModule, MatButtonModule, MatIconModule],
  templateUrl: './medication-view.component.html',
  styleUrl: './medication-view.component.scss'
})
export class MedicationViewComponent {
  displayedColumns: string[] = ['id', 'name', 'code', 'weight'];
  @Input() dataSource: Medication[] = [];
  captions: Map<string, string> = new Map<string, string> ([
    ['id', 'ID'],
    ['name', 'Name'],
    ['code', 'Code'],
    ['weight', 'Weight']
  ]);
}
