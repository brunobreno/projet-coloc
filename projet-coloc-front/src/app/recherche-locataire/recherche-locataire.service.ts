import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Locataire } from '../model';

@Injectable({
  providedIn: 'root'
})
export class RechercheLocataireService {

  locatairesUrl: string;

  constructor(private http:  HttpClient, private appConfing: AppConfigService) {
    this.locatairesUrl = this.appConfing.backEndUrl + "locataires/";
   }

  loadLocataires() : Observable<Array<Locataire>>{
    return this.http.get<Array<Locataire>>(this.locatairesUrl);
  }
}
