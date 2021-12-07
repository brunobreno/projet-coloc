import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Chambre, Commodite, Locataire, Logement, Regle } from '../model';

@Injectable({
  providedIn: 'root'
})
export class DescriptionLogementService {

  descriptionLogementUrl: string;
  logement: Logement;
  chambre: Chambre;
  commodites: Array<Commodite> = new Array<Commodite>();
  regles: Array<Regle> = new Array<Regle>();
  locataires: Array<Locataire> = new Array<Locataire>();

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.descriptionLogementUrl = this.appConfig.backEndUrl + "logements/"
  }

  findById(id: number): Observable<Logement> {
    return this.http.get<Logement>(this.descriptionLogementUrl + "complete/" + id);
  }

  findWithLocataire(id: number):  Observable<Array<Locataire>>  {
    return this.http.get<Locataire[]>(this.descriptionLogementUrl + "with-locataires/" + id);
  }

  /*findWithLocataire(id: number){
    console.log("passage par findLocatairesByLogement (service)")
    this.http.get<Array<Locataire>>(this.descriptionLogementUrl + "with-locataires/" + id).subscribe(response => {
      this.locataires = response;
    }, error => console.log(error));
  }*/



}
