import {NgModule} from '@angular/core';
import {CountryComponent} from "./country/country.component";
import {RouterModule, Routes} from "@angular/router";
import {CompetitionTableComponent} from "./competition-table/competition-table.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

const routes: Routes = [
  {path: 'country', component: CountryComponent},
  {path: 'tables', component: CompetitionTableComponent},
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
