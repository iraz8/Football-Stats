import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {Observable, timeout} from "rxjs";
import {Team} from "../entities/Team";
import {DataServiceComponent} from "../data-service/data-service.component";
import {Player} from "../entities/Player";


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
  playersByTeam: Observable<Player[]> | undefined;

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

  getPlayersByTeam(team: Team | undefined): void {
    if (team === undefined)
      return;
    this.playersByTeam = this.dataService.getPlayersByTeam(team.strTeam);
  }
}
