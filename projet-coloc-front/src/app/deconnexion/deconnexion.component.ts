import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { UtilisateurDTO } from '../model';

@Component({
  selector: 'app-deconnexion',
  templateUrl: './deconnexion.component.html',
  styleUrls: ['./deconnexion.component.scss']
})
export class DeconnexionComponent implements OnInit {

  constructor(private router: Router, private appConfig : AppConfigService) {
    this.appConfig.utilisateurConnecte = null;
    setTimeout(() =>{
      this.router.navigate(['']);
    }, 3000);
  }

  ngOnInit(): void {
  }

}
