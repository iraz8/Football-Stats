import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {DataServiceComponent} from "../data-service/data-service.component";

import {Team} from "../entities/Team";
import {Observable} from "rxjs";

@Component({
  selector: 'app-team-info',
  templateUrl: './team-info.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoComponent implements OnInit {
  clickedLeague?: League;
  leagues: Observable<League[]> | undefined;
  teamsDetailsByLeague: Observable<Team[]> | undefined;

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getLeagues();
  }

  getLeagues(): void {
    this.leagues = this.dataService.getLeagues();
  }

  getTeamsDetailsByLeagueName(league: League | undefined): void {
    if (league === undefined)
      return;
    this.teamsDetailsByLeague = this.dataService.getTeamsDetailsByLeague(league.strLeague);
  }

}
