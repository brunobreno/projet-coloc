import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Dossier, Locataire, LocataireDTOInscription, ProprietaireDTOInscription, UtilisateurDTO } from '../model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  utilisateurUrl: string;
  locataireUrl: string;
  proprietaireUrl: string;
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.utilisateurUrl = this.appConfig.backEndUrl + "utilisateurs/";
    this.proprietaireUrl = this.appConfig.backEndUrl + "proprietaires/";
    this.locataireUrl = this.appConfig.backEndUrl + "locataires/";
  }
  
  registerBack(utilisateur : UtilisateurDTO): Observable<UtilisateurDTO>{
    if(utilisateur.typeDeCompte == "locataire"){
      let dossierLocataireACreer = new Dossier(utilisateur.dossier.revenu, utilisateur.dossier.revenuGarant, utilisateur.dossier.situationGarant);
      let locataireACreer: LocataireDTOInscription = new LocataireDTOInscription(utilisateur.username, utilisateur.nom, utilisateur.prenom, utilisateur.civ, utilisateur.email, utilisateur.tel, utilisateur.password, utilisateur.recherche, utilisateur.description, utilisateur.situation, dossierLocataireACreer)
      return this.http.post<UtilisateurDTO>(this.locataireUrl, locataireACreer);

    } else {
      let proprietaireACreer: ProprietaireDTOInscription = new ProprietaireDTOInscription(utilisateur.username, utilisateur.nom, utilisateur.prenom, utilisateur.civ, utilisateur.email, utilisateur.tel, utilisateur.password)
      return this.http.post<UtilisateurDTO>(this.proprietaireUrl, proprietaireACreer);
    }
  }

  isUserAlreadyRegister(email : string): Observable<UtilisateurDTO> {
    return this.http.get<UtilisateurDTO>(this.utilisateurUrl + "find-by-email/" + email);
  }
}
