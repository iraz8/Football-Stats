import { Component, OnInit } from '@angular/core';
import {League} from "../entities/League";
import {Observable} from "rxjs";
import {Team} from "../entities/Team";
import {DataServiceComponent} from "../data-service/data-service.component";

@Component({
  selector: 'app-player-info',
  templateUrl: './player-info.component.html',
  styleUrls: ['./player-info.component.css']
})
export class PlayerInfoComponent implements OnInit {
  showFiller = false;
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
