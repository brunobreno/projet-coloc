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
  errorLogIn: String;

  constructor(private logInService: LogInService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.logInService.connexion(this.logInForm).subscribe(resp => {
      this.logInService.utilisateur = resp;
      this.router.navigate(['']);
      this.errorLogIn = null;
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
