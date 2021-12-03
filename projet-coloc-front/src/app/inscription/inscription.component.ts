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
  inscriptionRealise = false;
  emailExistant = false;

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

  register(){
    this.inscriptionService.isUserAlreadyRegister(this.inscriptionForm.email).subscribe(resp => {
      this.emailExistant = true;
    }, err => {
      if(err.status == 404) {
        //Si aucun utilisateur existant en base avec le meme email -> enregistrement du nouvel utilisateur
        this.emailExistant = false;
        this.inscriptionService.registerBack(this.inscriptionForm).subscribe(resp => {
          this.inscriptionRealise = true;
          setTimeout(() =>{
            this.inscriptionRealise = false;
            this.inscriptionForm = new UtilisateurDTO;
            this.router.navigate(['./login']);
          }, 3000);
        }, err => {console.log(err)});
        console.log(this.inscriptionForm);
      }
    })
  }
}
