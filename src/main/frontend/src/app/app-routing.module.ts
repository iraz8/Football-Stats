import {NgModule} from '@angular/core';
import {CountryComponent} from "./country/country.component";
import {RouterModule, Routes} from "@angular/router";

const routes: Routes = [
  {path: '', redirectTo: '/', pathMatch: 'full'},
  // { path: 'data', component: DataServiceComponent },
  {path: 'country', component: CountryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
