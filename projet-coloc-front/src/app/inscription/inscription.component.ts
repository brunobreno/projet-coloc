import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Dossier, UtilisateurDTO } from '../model';
import { InscriptionService } from './inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})

export class InscriptionComponent implements OnInit {

  inscriptionForm : UtilisateurDTO = new UtilisateurDTO();
  choixDossier: string;
  situations: Array<String> = new Array<string>();
  civilites: Array<String> = new Array<string>();

  constructor(private inscriptionService: InscriptionService, private appConfig: AppConfigService, private router: Router) {

    appConfig.findAllSituations().subscribe(resp => {
      this.situations = resp;
    }, err => console.log(err));

    appConfig.findAllCivilites().subscribe(resp => {
      this.civilites = resp;
    }, err => console.log(err));
    
    this.inscriptionForm.dossier = new Dossier();
  }

  ngOnInit(): void {
  }

  redirectLogIn(){
    this.router.navigate(['./login']);
  }

  inscriptionValidation(){
    // Faire la gestion de l'inscription suite à la saisie dans le formulaire
    console.log(this.inscriptionForm);
  }
}
