import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Commodite } from './model';

@Injectable({
  providedIn: 'root'
})
export class CommoditeHttpService {
  
  commodites: Array<Commodite> = new Array <Commodite>();
  commoditeUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.commoditeUrl = this.appConfig.backEndUrl + "commodites/"
    this.load();
   }

  findAll(): Array<Commodite> {
    return this.commodites;
  }

  findById(id: number): Observable<Commodite> {
    return this.http.get<Commodite>(this.commoditeUrl + id);
  }

  findAllByIdLogement(id: number): Observable<Array<Commodite>> {
    return this.http.get<Commodite[]>(this.commoditeUrl + "by-logement/" + id);
  }

  create(commodite: Commodite) {
    this.http.post<Commodite>(this.commoditeUrl, commodite).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(commodite: Commodite) {
    this.http.put<Commodite>(this.commoditeUrl + commodite.id, commodite).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.commoditeUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Commodite>>(this.commoditeUrl).subscribe(response => {
      this.commodites = response;
    }, error => console.log(error));
  }
}
