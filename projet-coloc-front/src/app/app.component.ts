import { Component } from '@angular/core';
import { MapHttpService } from './map/map-http.service';
import { Logement, Proprietaire, Utilisateur, UtilisateurDTO } from './model';
import { Locataire } from './model';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { RechercheLogementService } from './recherche-logement/recherche-logement.service';
import { Router } from '@angular/router';

// import des incons fontawesome
import { faCalendarAlt } from '@fortawesome/free-solid-svg-icons';
import { faMoneyBill } from '@fortawesome/free-solid-svg-icons';
import { faUsers } from '@fortawesome/free-solid-svg-icons';
import { faExpandAlt } from '@fortawesome/free-solid-svg-icons';
import { faCommentAlt } from '@fortawesome/free-solid-svg-icons';
import { faFileDownload } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'projet-coloc-front';
  utilisateurConnecte: UtilisateurDTO;
  

  //icons fontawesome
  faCalendar = faCalendarAlt;
  faMoneyBill = faMoneyBill;
  faUsers = faUsers;
  faExpandAlt = faExpandAlt;
  faCommentAlt = faCommentAlt;
  faFileDownload = faFileDownload;


  filtreVille: string;

  constructor(private rechercheLogement: RechercheLogementComponent, private rechercheLogementService: RechercheLogementService, private mapService:MapHttpService,public router: Router) {
    this.utilisateurConnecte = new UtilisateurDTO;
   // this.utilisateurConnecte.typeDeCompte="locataire";
    this.utilisateurConnecte.typeDeCompte="locataire";
  }

  search(ville: string) {
    this.rechercheLogement.search(ville);
    //return this.rechercheLogementService.findAll();

    this.getCoordVille(); //Coordonnees pour centrer la map

  }

  getCoordVille(){
    
    this.mapService.getCoordVille(this.filtreVille);
  }

  isHomeRoute() {
    return this.router.url === '/home';
  }
 
}
