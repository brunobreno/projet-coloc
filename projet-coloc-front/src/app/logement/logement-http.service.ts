import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement } from '../model';

@Injectable({
  providedIn: 'root'
})
export class LogementHttpService {

  logements: Array<Logement> = new Array<Logement>();
  logementUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.logementUrl = this.appConfig.backEndUrl + "logements/"
    this.load();
   }

   findAll(): Array<Logement> {
     return this.logements;
   }

  findById(id: number): Observable<Logement> {
    return this.http.get<Logement>(this.logementUrl + id);
  }

  findAllByIdProprietaire(id: number): Observable<Array<Logement>> {
    return this.http.get<Logement[]>(this.logementUrl + "by-proprietaire/" + id);
  }

  create(logement: Logement) {
    this.http.post<Logement>(this.logementUrl, logement).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(logement: Logement) {
    this.http.put<Logement>(this.logementUrl + logement.id, logement).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.logementUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Logement>>(this.logementUrl).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }

}
