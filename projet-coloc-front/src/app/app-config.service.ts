import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UtilisateurDTO } from './model';

// import des incons fontawesome
import { faCalendarAlt, faCouch } from '@fortawesome/free-solid-svg-icons';
import { faMoneyBill } from '@fortawesome/free-solid-svg-icons';
import { faUsers } from '@fortawesome/free-solid-svg-icons';
import { faExpandAlt } from '@fortawesome/free-solid-svg-icons';
import { faCommentAlt } from '@fortawesome/free-solid-svg-icons';
import { faFileDownload } from '@fortawesome/free-solid-svg-icons';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  backEndUrl: string = "http://localhost:8080/";
  utilisateurConnecte: UtilisateurDTO;

  
  //icons fontawesome
  faCalendar=faCalendarAlt;
  faMoneyBill=faMoneyBill;
  faUsers=faUsers;
  faExpandAlt=faExpandAlt;
  faCommentAlt=faCommentAlt;
  faFileDownload=faFileDownload;
  faCouch=faCouch;


  constructor(private http : HttpClient) { }

  findAllCivilites(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "civilites");
  }

  findAllSituations(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "situations");
  }


}

