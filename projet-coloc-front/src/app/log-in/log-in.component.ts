import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { ConnexionDTO } from '../model';
import { LogInService } from './log-in.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {
  
  logInForm: ConnexionDTO = new ConnexionDTO();
  errorLogIn: string;
  connexionEtablie: boolean = false;

  constructor(private logInService: LogInService, private router: Router, private appConfig: AppConfigService) { }

  ngOnInit(): void {
  }

  login() {
    this.logInService.connexion(this.logInForm).subscribe(resp => {
      this.logInService.findUserById(resp.id).subscribe(userResp => {
        this.appConfig.utilisateurConnecte = userResp;
        if(userResp.description){
          this.appConfig.utilisateurConnecte.typeDeCompte = "locataire"
        } else {
          this.appConfig.utilisateurConnecte.typeDeCompte = "proprietaire"
        }
        this.connexionEtablie = true;
        this.errorLogIn = null;
        setTimeout(() =>{
          this.connexionEtablie = false;
          this.logInForm = new ConnexionDTO();
          this.router.navigate(['']);
        }, 3000);
      }, err => console.log(err))
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogIn = "L'utilisateur ou le mot de passe est incorrect !"
      }
    });
  }
  
  redirectInscription(){
    this.router.navigate(['./inscription']);
  }

}
