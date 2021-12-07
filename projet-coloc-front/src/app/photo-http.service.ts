import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppConfigService } from './app-config.service';
import { Photo } from './model';

@Injectable({
  providedIn: 'root'
})
export class PhotoHttpService {

  album: Array<Photo> = new Array<Photo>();
  photoUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.photoUrl = this.appConfig.backEndUrl + "album/"
    this.load();
  }

  findAll(): Array<Photo> {
    return this.album;
  }

  findById(id: number): Observable<Photo> {
    return this.http.get<Photo>(this.photoUrl + id);
  }

  findAllByIdLogement(id: number): Observable<Array<Photo>> {
    return this.http.get<Photo[]>(this.photoUrl + "by-logement/" + id);
  }

  create(photo: Photo) {
    this.http.post<Photo>(this.photoUrl, photo).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(photo: Photo) {
    this.http.put<Photo>(this.photoUrl + photo.id, photo).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.photoUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Photo>>(this.photoUrl).subscribe(response => {
      this.album = response;
    }, error => console.log(error));
  }
}
