import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Message, MessageDTO, UtilisateurDTO } from '../model';

@Injectable({
  providedIn: 'root'
})
export class MessagerieService {

  utilisateurUrl: string;
  messagerieUrl: string;

  constructor(private appConfig: AppConfigService, private http: HttpClient) {
    this.utilisateurUrl = appConfig.backEndUrl + "utilisateurs/"
    this.messagerieUrl = appConfig.backEndUrl + "messages/"
   }

  findUtilisateurById(id: number): Observable<UtilisateurDTO>{
    return this.http.get<UtilisateurDTO>(this.utilisateurUrl + "with-role" + id);
  }

  findMessagesById(id: number): Observable<Array<Message>>{
    return this.http.get<Array<Message>>(this.messagerieUrl + "all-by-id/" + id);
  }

  sendMessage(message : MessageDTO): Observable<Message>{
    return this.http.post<Message>(this.messagerieUrl, message);
  }
}
