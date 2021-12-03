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
  logementUrl: string;
  logement: Logement;

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
    console.log('passage par findByVilleWithCom')
    this.http.get<Array<Logement>>(this.logementUrl + "by-ville/" + ville + "/with-commodite").subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }
  
  load() {
    this.http.get<Array<Logement>>(this.logementUrl + "/with-commodite" ).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }


}
