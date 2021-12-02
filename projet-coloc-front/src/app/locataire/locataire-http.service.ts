import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './../app-config.service';
import { Locataire } from '../model';

@Injectable({
  providedIn: 'root'
})
export class LocataireHttpService {

  locataires: Array<Locataire> = new Array<Locataire>();
  locataireUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.locataireUrl = this.appConfig.backEndUrl + "locataires/"
    this.load();
  }

  modify(locataire: Locataire) {
    this.http.put<Locataire>(this.locataireUrl + locataire.id, locataire).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  findById(id:number): Observable<Locataire> {
    return this.http.get<Locataire>(this.locataireUrl + id);
  }

  load() {
    this.http.get<Array<Locataire>>(this.locataireUrl).subscribe(response => {
      this.locataires = response;
    }, error => console.log(error));
  }

}
