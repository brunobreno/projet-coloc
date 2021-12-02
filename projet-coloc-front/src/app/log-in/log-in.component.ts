import { Component, OnInit } from '@angular/core';
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

  constructor(private logInService: LogInService) { }

  ngOnInit(): void {
  }

  login() {
    this.logInService.connexion(this.logInForm).subscribe(resp => {
      this.logInService.utilisateur = resp;
      console.log(resp.email)
      this.errorLogIn = null;
    }, error => {
      console.log(error);
      if(error.status == 404) {
        this.errorLogIn = "L'utilisateur ou le mot de passe est incorrect !"
      }
    });
  }
}
