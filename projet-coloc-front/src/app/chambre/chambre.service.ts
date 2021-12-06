import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../app-config.service';
import { Chambre } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ChambreService {

  chambreUrl: string;


  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.chambreUrl = this.appConfig.backEndUrl + "chambres/"
   }

  findById(id: number): Observable<Chambre> {
    return this.http.get<Chambre>(this.chambreUrl + id);
  }

  findByLogement(id: number):  Observable<Array<Chambre>>  {
    return this.http.get<Chambre[]>(this.chambreUrl + "by-logement/with-detail/" + id);
  }

}
