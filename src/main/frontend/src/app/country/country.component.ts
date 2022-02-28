import {Component, OnInit} from '@angular/core';
import {Country} from "../entities/Country";
import {DataServiceComponent} from "../data-service/data-service.component";

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.css']
})
export class CountryComponent implements OnInit {

  countries: Country[] = [];

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getCountries();
  }


  getCountries(): void {
    this.dataService.getCountries().subscribe(countries => this.countries = countries);
    console.log("country.component");
  }
}
