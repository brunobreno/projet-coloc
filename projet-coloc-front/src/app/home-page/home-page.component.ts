import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { MapHttpService } from '../map/map-http.service';
import { Logement } from '../model';
import { RechercheLogementComponent } from '../recherche-logement/recherche-logement.component';
import { HomePageService } from './home-page.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  logementRecents = new Array<Logement>();

  filtreVille: string;

  constructor(private mapService:MapHttpService, private rechercheLogement: RechercheLogementComponent,private homeService: HomePageService, private appConfig: AppConfigService) { 
     homeService.loadMostRecentLogements().subscribe(resp => {
       this.logementRecents = resp;
     }, err => console.log(err))
  }

  ngOnInit(): void {
  }

  search(ville:string) {
    console.log('passage par search')
    this.rechercheLogement.search(ville);
    //return this.rechercheLogementService.findAll();

    this.getCoordVille(); //Coordonnees pour centrer la map
    
  }

  getCoordVille(){
    
    this.mapService.getCoordVille(this.filtreVille);
  }


}
