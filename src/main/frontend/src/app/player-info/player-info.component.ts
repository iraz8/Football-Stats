import {Component, OnInit} from '@angular/core';
import {League} from "../entities/League";
import {Observable} from "rxjs";
import {Team} from "../entities/Team";
import {DataServiceComponent} from "../data-service/data-service.component";
import {Country} from "../entities/Country";

@Component({
  selector: 'app-player-info',
  templateUrl: './player-info.component.html',
  styleUrls: ['./player-info.component.css']
})


interface LeagueNode {
  league: League;
  teams?: Team[];
}

interface CountryNode {
  country: Country;
  children?: LeagueNode[];
}


export class PlayerInfoComponent implements OnInit {

  clickedLeague?: League;
  leagues: Observable<League[]> | undefined;
  countries: Country[] | undefined;
  const
  TREE_DATA: Country[] = [
    this.countries;

  constructor(private dataService: DataServiceComponent) {
  }

  ngOnInit(): void {
    this.getCountries();
    this.getLeagues();
  }

  getLeagues(): void {
    this.leagues = this.dataService.getLeagues();
  }

  getCountries(): void {
    this.dataService.getCountries().subscribe((c) => this.countries = c);

  }

  buildNodes(): CountryNode[] | undefined {
    let countriesNodeList: CountryNode[] = [];
    if (this.countries)
      return;
    for (let country of this.countries) {


      const countryNode: CountryNode = {
        country: country,

      }
      countriesNodeList.push(new CountryNode(country, undefined))

    }
  }

]
}


interface FoodNode {
  name: string;
  children?: FoodNode[];
}

const TREE_DATA: FoodNode[] = [
  {
    name: 'Fruit',
    children: [{name: 'Apple'}, {name: 'Banana'}, {name: 'Fruit loops'}],
  },
  {
    name: 'Vegetables',
    children: [
      {
        name: 'Green',
        children: [{name: 'Broccoli'}, {name: 'Brussels sprouts'}],
      },
      {
        name: 'Orange',
        children: [{name: 'Pumpkins'}, {name: 'Carrots'}],
      },
    ],
  },
];

/**
 * @title Tree with nested nodes
 */
@Component({
  selector: 'tree-nested-overview-example',
  templateUrl: 'tree-nested-overview-example.html',
  styleUrls: ['tree-nested-overview-example.css'],
})
export class TreeNestedOverviewExample {
  treeControl = new NestedTreeControl<FoodNode>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FoodNode>();

  constructor() {
    this.dataSource.data = TREE_DATA;
  }

  hasChild = (_: number, node: FoodNode) => !!node.children && node.children.length > 0;
}
