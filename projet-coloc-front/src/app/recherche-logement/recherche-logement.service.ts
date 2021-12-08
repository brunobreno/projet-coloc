import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from './../app-config.service';
import { Commodite, Locataire, Logement } from '../model';




@Injectable({
  providedIn: 'root'
})
export class RechercheLogementService {

  logements: Array<Logement> = new Array<Logement>();
  logementsByVille:Array<Logement> = new Array<Logement>();
 
  logementUrl: string;
  logement: Logement;
  locatairesLogement: Array<Locataire> = new Array<Locataire>();
  filtreVille: string ;
  

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


  findByVille(ville: string){
    
    if (ville) {
      this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville ).subscribe(response => {
        this.logements = response;
        this.logementsByVille = response;
        this.filtreVille=ville;
        console.log("passage par findByVille (service)" + this.filtreVille)
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

  findByVilleWithCom(ville: string){
    this.filtreVille = ville;
    console.log('passage par findByVilleWithCom')
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite").subscribe(response => {
      this.logements = response;
      this.logementsByVille = response;
    }, error => console.log(error));
  }*/
  
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
    this.http.get<Array<Logement>>(this.logementUrl + "complete" ).subscribe(response => {
    console.log("passage par load (service)")
      this.logements = response;
      console.log("load " + JSON.stringify(this.logements))
    }, error => console.log(error));
  }

  findLocatairesByLogement(id: number){
    console.log("passage par findLocatairesByLogement (service)")
    this.http.get<Array<Locataire>>(this.logementUrl + "with-locataires/" + id).subscribe(response => {
      this.locatairesLogement = response;
    }, error => console.log(error));
  }



}
