import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {DataServiceComponent} from "../data-service/data-service.component";

@Component({
  selector: 'app-competition-table',
  templateUrl: './competition-table.component.html',
  styleUrls: ['./competition-table.component.css']
})
export class CompetitionTableComponent implements OnInit {
  leagues: League[] = [];

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getLeagues();
  }

  getLeagues(): void {
    this.dataService.getLeagues().subscribe(leagues => this.leagues = leagues);
  }
}
