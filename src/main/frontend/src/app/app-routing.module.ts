import {NgModule} from '@angular/core';
import {CountryComponent} from "./country/country.component";
import {RouterModule, Routes} from "@angular/router";
import {CompetitionTableComponent} from "./competition-table/competition-table.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {TeamInfoComponent} from "./team-info/team-info.component";
import {PlayerInfoComponent} from "./player-info/player-info.component";

const routes: Routes = [
  {path: 'tables', component: CompetitionTableComponent},
  {path: 'team-info', component: TeamInfoComponent},
  {path: 'players-info', component: PlayerInfoComponent},
  {path: 'country', component: CountryComponent},
  {path: '', redirectTo: 'tables', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
