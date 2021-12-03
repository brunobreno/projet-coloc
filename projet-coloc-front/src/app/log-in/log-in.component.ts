import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  constructor(private logInService: LogInService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.logInService.connexion(this.logInForm).subscribe(resp => {
      this.logInService.utilisateur = resp;
      this.connexionEtablie = true;
      this.errorLogIn = null;
      setTimeout(() =>{
        this.connexionEtablie = false;
        this.logInForm = new ConnexionDTO();
        this.router.navigate(['']);
      }, 3000);
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
