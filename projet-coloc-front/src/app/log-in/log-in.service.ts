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

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.utilisateurUrl = this.appConfig.backEndUrl + "utilisateurs/"
   }

   connexion(connexion: ConnexionDTO): Observable<UtilisateurDTO> {
    return this.http.post<UtilisateurDTO>(this.utilisateurUrl + "login", connexion);
  }

  deconnexion() {
    this.utilisateur = null;
  }
}
