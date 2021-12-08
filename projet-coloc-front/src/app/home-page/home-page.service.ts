import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement, Photo } from '../model';

@Injectable({
  providedIn: 'root'
})
export class HomePageService {

  logementsUrl: string;
  photosUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) { 
    this.logementsUrl = appConfig.backEndUrl + "logements/";
    this.photosUrl = appConfig.backEndUrl + "photos/";
  }

  loadMostRecentLogements():Observable<Array<Logement>>{
    return this.http.get<Array<Logement>>(this.logementsUrl + "most-recent-with-dispo");
  }

  loadPhotoByLogement(id: number):Observable<Array<Photo>> {
    return this.http.get<Array<Photo>>(this.photosUrl + "by-logement/" + id);
  }

}
