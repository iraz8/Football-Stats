import {Component, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";

import {Country} from "../entities/Country"
import {MessageService} from "./message.service";
import {League} from "../entities/League";
import {CompetitionTable} from "../entities/CompetitionTable";
import {Team} from "../entities/Team";

@Component({
  selector: 'app-data-service',
  templateUrl: './data-service.component.html',
  styleUrls: ['./data-service.component.css']
})

@Injectable({providedIn: 'root'})
export class DataServiceComponent {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
    })
  };
  private countryUrl = 'http://localhost:8080/api/countries';
  private leaguesUrl = 'http://localhost:8080/api/leagues';
  private competitionTableUrl = 'http://localhost:8080/api/table';
  private teamsUrl = 'http://localhost:8080/api/teams';
  private playersUrl = 'http://localhost:8080/api/player';
  private competitionNameParamKey = "competition_name";
  private seasonParamKey = "season";

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {
  }

  getCompetitionTable(competitionName: string | undefined, season: string = "2021-2022"): Observable<CompetitionTable[]> {
    let params: string = `?${this.competitionNameParamKey}=${competitionName}&${this.seasonParamKey}=${season}`;
    return this.http.get<CompetitionTable[]>(this.competitionTableUrl + params)
      .pipe(
        tap(_ => this.log('fetched competitionTables')),
        catchError(this.handleError<CompetitionTable[]>('getCompetitionTables', []))
      );
  }

  getCountries(): Observable<Country[]> {
    return this.http.get<Country[]>(this.countryUrl)
      .pipe(
        tap(_ => this.log('fetched countries')),
        catchError(this.handleError<Country[]>('getCountries', []))
      );
  }

  getLeagues(): Observable<League[]> {
    return this.http.get<League[]>(this.leaguesUrl)
      .pipe(
        tap(_ => this.log('fetched leagues')),
        catchError(this.handleError<League[]>('getLeagues', []))
      );
  }

  getTeamsDetailsByLeague(competitionName: string | undefined): Observable<Team[]> {
    let teamsDetailsByLeagueUrl = `${this.teamsUrl}/${competitionName}`;
    return this.http.get<Team[]>(teamsDetailsByLeagueUrl)
      .pipe(
        tap(_ => this.log(`fetched teams from ${competitionName}`)),
        catchError(this.handleError<Team[]>(`getTeamsDetailsByLeague from ${competitionName}`, []))
      );
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   *
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a DataService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`DataServiceComponent: ${message}`);
  }
}


