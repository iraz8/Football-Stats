import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {DataServiceComponent} from './data-service/data-service.component';
import {RouterModule} from "@angular/router";
import {CountryComponent} from './country/country.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatMenuModule} from "@angular/material/menu";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatRippleModule} from "@angular/material/core";
import {CompetitionTableComponent} from './competition-table/competition-table.component';
import {MatExpansionModule} from "@angular/material/expansion";
import {MatTableModule} from "@angular/material/table";
import {MatToolbarModule} from "@angular/material/toolbar";
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {TeamInfoComponent} from './team-info/team-info.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatTreeModule} from "@angular/material/tree";
import { PlayerInfoComponent } from './player-info/player-info.component';
import {MatSidenavModule} from "@angular/material/sidenav";

@NgModule({
  declarations: [
    AppComponent,
    DataServiceComponent,
    CountryComponent,
    CompetitionTableComponent,
    PageNotFoundComponent,
    TeamInfoComponent,
    PlayerInfoComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatListModule,
    MatCardModule,
    MatGridListModule,
    MatMenuModule,
    MatButtonModule,
    MatIconModule,
    MatRippleModule,
    MatExpansionModule,
    MatTableModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatTreeModule,
    MatSidenavModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
