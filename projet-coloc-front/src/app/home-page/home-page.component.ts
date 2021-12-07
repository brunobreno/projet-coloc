import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AppConfigService } from '../app-config.service';
import { Logement } from '../model';
import { HomePageService } from './home-page.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  logementRecents = new Array<Logement>();
  saisieVille: string;

  constructor(private homeService: HomePageService, private appConfig: AppConfigService, private router: Router) {
    homeService.loadMostRecentLogements().subscribe(resp => {
      this.logementRecents = resp;
      this.logementRecents.forEach(log => {
        this.homeService.loadPhotoByLogement(log.id).subscribe(resp => {
          log.photos = resp;
        }, err => console.log)
      });
    }, err => console.log(err))
  }

  ngOnInit(): void {
  }

  redirect(id: number) {
    this.router.navigate(["./description-logement/", id]);
  }

  redirectVille(ville: string) {
    this.router.navigate(["./recherche-logement/", ville]);
  }

  rechercheVille() {
    this.redirectVille(this.saisieVille);
    this.saisieVille = null;
  }

  isEnter(event: any) {
    if (event.keyCode == 13) {
      this.rechercheVille();
    }
  }
}
