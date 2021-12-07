import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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

  constructor(private homeService: HomePageService, private appConfig: AppConfigService) { 
     homeService.loadMostRecentLogements().subscribe(resp => {
       this.logementRecents = resp;
     }, err => console.log(err))
  }

  ngOnInit(): void {
  }

}
