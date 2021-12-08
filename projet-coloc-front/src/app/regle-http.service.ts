import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Regle } from './model';

@Injectable({
  providedIn: 'root'
})
export class RegleHttpService {
  regles: Array<Regle> = new Array <Regle>();
  regleUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.regleUrl = this.appConfig.backEndUrl + "regles/"
    this.load();
   }

  findAll(): Array<Regle> {
    return this.regles;
  }

  findById(id: number): Observable<Regle> {
    return this.http.get<Regle>(this.regleUrl + id);
  }

  findAllByIdLogement(id: number): Observable<Array<Regle>> {
    return this.http.get<Regle[]>(this.regleUrl + "by-logement/" + id);
  }

  create(regle: Regle) {
    this.http.post<Regle>(this.regleUrl, regle).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(regle: Regle) {
    this.http.put<Regle>(this.regleUrl + regle.id, regle).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.regleUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Regle>>(this.regleUrl).subscribe(response => {
      this.regles = response;
    }, error => console.log(error));
  }
}
