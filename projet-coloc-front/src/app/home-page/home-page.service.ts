import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement } from '../model';

@Injectable({
  providedIn: 'root'
})
export class HomePageService {

  locataireUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.locataireUrl = appConfig.backEndUrl + "logements/";
  }

  loadMostRecentLogements():Observable<Array<Logement>>{
    return this.http.get<Array<Logement>>(this.locataireUrl + "most-recent-with-dispo");
  }

}
