import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'leaflet';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement } from '../model';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';


@Injectable({
  providedIn: 'root'
})
export class MapHttpService {

  mapUrl: string;
  result: any;
  coordonnees: Array<number>;

  coordonneesAdresses: Array<Array<number>> = new Array<Array<number>>();
  resultat: any;
  lon:number;
  lat:number;

  constructor(private http: HttpClient, private appConfig: AppConfigService, private rechercheService: RechercheLogementService) {
  }


  // getCoordVille() {
  //   let promise = new Promise<void>((resolve, reject) => {
  //     let apiUrl = `https://api-adresse.data.gouv.fr/search/?q=${this.rechercheService.filtreVille}&limit=1`;
  //     this.http.get(apiUrl)
  //       .toPromise()
  //       .then(
  //         res => {
  //           console.log('resultat api : ' + JSON.stringify(res));
  //           this.resultat = res;
  //           for (const c of this.resultat.features) {
  //              this.lon = c.geometry.coordinates[0];
  //              this.lat = c.geometry.coordinates[1];
  //             console.log(this.lat)
  //             console.log(this.lon)
              
  //           }
  //             resolve();
  //         }
  //       );

  //   });
  //   return promise;
  // }

  // getCoordLogements(num: number, voie: string, cp: string, ville: string) {
  //   this.http.get("https://api-adresse.data.gouv.fr/search/?q=" + num + "+" + voie + "&postcode=" + cp + "&city=" + ville + "&limit=1").subscribe(
  //     res => {
  //       this.resultat = res;
  //       // console.log('resultat res = ' + this.resultat);
  //       this.coordonneesAdresses.push(this.resultat.features[0].geometry.coordinates);
  //       console.log("AllCoordonneesLogements : " + this.coordonneesAdresses);
  //       // return this.resultat;
  //     }
  //   );
  // }
  

}
