import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UtilisateurDTO } from './model';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  backEndUrl: string = "http://localhost:8080/";
  utilisateurConnecte: UtilisateurDTO;

  constructor(private http : HttpClient) { }

  findAllCivilites(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "civilites");
  }

  findAllSituations(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "situations");
  }


}

