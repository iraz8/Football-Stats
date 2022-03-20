import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {DataServiceComponent} from "../data-service/data-service.component";
import {CompetitionTable} from "../entities/CompetitionTable";

@Component({
  selector: 'app-competition-table',
  templateUrl: './competition-table.component.html',
  styleUrls: ['./competition-table.component.css']
})
export class CompetitionTableComponent implements OnInit {
  displayedColumns: string[] = ['Rank', 'Badge', 'Name', 'Played', 'Win', 'Draw', 'Loss', 'Goals', 'Form', 'Points'];

  leagues: League[] = [];
  competitionTable: CompetitionTable[] = [];

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getLeagues();
  }

  getLeagues(): void {
    this.dataService.getLeagues().subscribe(leagues => this.leagues = leagues);
  }

  getCompetitionTable(leagueName: string): void {
    this.dataService.getCompetitionTable(leagueName).subscribe(table => this.competitionTable = table);
  }

  formatLine(resultsLine: CompetitionTable): string {
    return `${resultsLine.intRank}. ${resultsLine.strTeam} ${resultsLine.intPoints}`;
  }

  printCompetitionTable(league: League) {
    this.getCompetitionTable(league.strLeague);
  }
}
