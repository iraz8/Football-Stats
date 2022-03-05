import {NgModule} from '@angular/core';
import {CountryComponent} from "./country/country.component";
import {RouterModule, Routes} from "@angular/router";
import {CompetitionTableComponent} from "./competition-table/competition-table.component";

const routes: Routes = [
  {path: '', redirectTo: '/', pathMatch: 'full'},
  {path: 'country', component: CountryComponent},
  {path: 'tables', component: CompetitionTableComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
