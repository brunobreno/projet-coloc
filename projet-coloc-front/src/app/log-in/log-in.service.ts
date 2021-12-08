import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { ConnexionDTO, UtilisateurDTO } from '../model';

@Injectable({
  providedIn: 'root'
})
export class LogInService {

  utilisateurUrl: string;
  utilisateur: UtilisateurDTO;
  proprietairesUrl:string;
  locatairesUrl:string;


  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.utilisateurUrl = this.appConfig.backEndUrl + "utilisateurs/"
    this.proprietairesUrl = this.appConfig.backEndUrl + "proprietaires/"
    this.locatairesUrl = this.appConfig.backEndUrl + "locataires/"
   }

   connexion(connexion: ConnexionDTO): Observable<UtilisateurDTO> {
    return this.http.post<UtilisateurDTO>(this.utilisateurUrl + "login", connexion);
  }

  findUserById(id:number): Observable<UtilisateurDTO>{
    return this.http.get<UtilisateurDTO>(this.utilisateurUrl + id);
  }

  findLocataireById(id:number): Observable<UtilisateurDTO>{
    return this.http.get<UtilisateurDTO>(this.locatairesUrl + id);
  }

  deconnexion() {
    this.utilisateur = null;
  }
}
