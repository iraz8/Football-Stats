import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {CompetitionTable} from "../entities/CompetitionTable";
import {DataServiceComponent} from "../data-service/data-service.component";

import {Team} from "../entities/Team";

@Component({
  selector: 'app-team-info',
  templateUrl: './team-info.component.html',
  styleUrls: ['./team-info.component.css']
})
export class TeamInfoComponent implements OnInit {
  displayedColumns: string[] = ['Badge', 'Name'];

  leagues: League[] = [];
  competitionTable: CompetitionTable[] = [];
  teamsDetails: Team[] = [];

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getLeagues();
    // this.getTeamsDetailsByLeague("English%20Premier%20League");
  }

  getLeagues(): void {
    this.dataService.getLeagues().subscribe(leagues => this.leagues = leagues);
  }

  getCompetitionTable(leagueName: string): void {
    this.dataService.getCompetitionTable(leagueName).subscribe(table => this.competitionTable = table);
  }

  getTeamsDetailsByLeague(leagueName: string): void {
    this.dataService.getTeamsDetailsByLeague(leagueName).subscribe(teams => this.teamsDetails = teams);
  }

  formatLine(resultsLine: CompetitionTable): string {
    return `${resultsLine.intRank}. ${resultsLine.strTeam} ${resultsLine.intPoints}`;
  }

  printCompetitionTable(league: League) {
    this.getCompetitionTable(league.strLeague);
  }

  printTeamsDetailsByLeague(league: League) {
    this.getCompetitionTable(league.strLeague);
    this.getTeamsDetailsByLeague(league.strLeague);
    console.log(this.teamsDetails);
    // setTimeout(() => { console.log(this.teamsDetails)}, 1000); //TODO FIX ME
    // this.getTeamsDetailsByLeague(league.strLeague);
  }
}
