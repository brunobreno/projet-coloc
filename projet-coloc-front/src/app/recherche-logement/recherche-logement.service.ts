import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './../app-config.service';
import { Commodite, Logement } from '../model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RechercheLogementService {

  logements: Array<Logement> = new Array<Logement>();
  logementsByVille:Array<Logement> = new Array<Logement>();
 
  logementUrl: string;
  logement: Logement;
  filtreVille: string;
  

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.logementUrl = this.appConfig.backEndUrl + "logements/"
    this.load();
  }

  findAll(): Array<Logement> {
    return this.logements;
  }


  findByVille(ville: string){
    console.log('passage par findByVille')
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }


  findByVilleWithCom(ville: string){
    this.filtreVille = ville;
    console.log('passage par findByVilleWithCom')
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite").subscribe(response => {
      this.logements = response;
      this.logementsByVille = response;
    }, error => console.log(error));
  }
  
  // findbyFiltreType(listeFiltres: Array<string>){
  //   this.load();
  //   console.log('passage par filtre type');
  //   var newLogements: Array<Logement> = new Array<Logement>();
  //   this.logements = this.logements.filter(function(log) {
  //     for(let f of listeFiltres) {
  //       if(log.typeLogement == f) {
  //         newLogements.push(log);
  //       }
  //     }
  //   });
  //   return this.logements = newLogements;
  // }

  load() {
    this.http.get<Array<Logement>>(this.logementUrl + "with-commodite" ).subscribe(response => {
      this.logements = response;
      console.log("load " + this.logements)
    }, error => console.log(error));
  }




}
