import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {

  utilisateurUrl: string
  
  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.utilisateurUrl = this.appConfig.backEndUrl + "utilisateurs/"
  }
  
}
