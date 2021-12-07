import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MapHttpService {

  mapUrl: string;
  result: any;
  coordonnees:Array<number>;

  
  resultat:any;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
  }



  getCoordVille(ville: string) {
    this.http.get("https://api-adresse.data.gouv.fr/search/?q=" + ville + "&limit=1").subscribe(
      res => {
        this.result = res;
        this.coordonnees = this.result.features[0].geometry.coordinates;
        // console.log(this.result.features);
        // this.x = this.result.features[0].geometry.coordinates[0];
        // this.y = this.result.features[0].geometry.coordinates[1];
        // console.log("Coordonné x : " + this.x + " y : " + this.y);
      }
    );
  }

  getCoordLogements(num:number,voie:string,cp:string,ville:string){
      this.http.get("https://api-adresse.data.gouv.fr/search/?q=" + num+ "+" +voie+ "&postcode=" +cp+ "city=" +ville+ "&limit=1").subscribe(
        res => {
          this.resultat = res;
          console.log('resultat res = ' + this.resultat);
          return this.resultat;
      } 
      );
  }

 

}
