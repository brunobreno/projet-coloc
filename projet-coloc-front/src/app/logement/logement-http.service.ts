import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './../app-config.service';
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


  create(logement: Logement) {
    this.http.post<Logement>(this.logementUrl, logement).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }


  load() {
    this.http.get<Array<Logement>>(this.logementUrl).subscribe(response => {
      this.logements = response;
    }, error => console.log(error));
  }
}
