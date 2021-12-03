import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Proprietaire } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ProprietaireHttpService {

  proprietaires: Array<Proprietaire> = new Array <Proprietaire>();
  proprietaireUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.proprietaireUrl = this.appConfig.backEndUrl + "proprietaires/"
    this.load();
   }

  findAll(): Array<Proprietaire> {
    return this.proprietaires;
  }

  findById(id: number): Observable<Proprietaire> {
    return this.http.get<Proprietaire>(this.proprietaireUrl + id);
  }

  create(proprietaire: Proprietaire) {
    this.http.post<Proprietaire>(this.proprietaireUrl, proprietaire).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(proprietaire: Proprietaire) {
    this.http.put<Proprietaire>(this.proprietaireUrl + proprietaire.id, proprietaire).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.proprietaireUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Proprietaire>>(this.proprietaireUrl).subscribe(response => {
      this.proprietaires = response;
    }, error => console.log(error));
  }
}
