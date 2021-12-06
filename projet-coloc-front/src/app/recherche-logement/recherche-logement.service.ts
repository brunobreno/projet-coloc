import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './../app-config.service';
import { Commodite, Locataire, Logement } from '../model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RechercheLogementService {

  logements: Array<Logement> = new Array<Logement>();
  logementUrl: string;
  logement: Logement;
  locatairesLogement: Array<Locataire> = new Array<Locataire>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.logementUrl = this.appConfig.backEndUrl + "logements/"
    this.load();
  }

  findAll(): Array<Logement> {
    console.log("passage par findAll")
    return this.logements;
  }


 /* findByVille(ville: string){
    console.log("passage par countLocataires")
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }*/


  findByVilleWithCom(ville: string){
    console.log("passage par findByVilleWithCom (service)")
    if (ville) {
      this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite").subscribe(response => {
        this.logements = response;
      }, error => console.log(error));
    } else {
      this.load();
    }
    
  }

  /*findByVilleWithComLoyerAsc(ville: string){
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite/order-by-price-asc").subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }

  findByVilleWithComLoyerDesc(ville: string){
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite/order-by-price-desc").subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }*/
  
  load() {
    console.log("passage par load (service)")
    this.http.get<Array<Logement>>(this.logementUrl + "with-commodite" ).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }

  findLocatairesByLogement(id: number){
    console.log("passage par findLocatairesByLogement (service)")
    this.http.get<Array<Locataire>>(this.logementUrl + "with-locataires/" + id).subscribe(response => {
      this.locatairesLogement = response;
    }, error => console.log(error));
  }

}
