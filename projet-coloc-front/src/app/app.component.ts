import { Component } from '@angular/core';
import { MapHttpService } from './map/map-http.service';
import { Logement, Proprietaire, Utilisateur, UtilisateurDTO } from './model';
import { Locataire } from './model';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { RechercheLogementService } from './recherche-logement/recherche-logement.service';
import { Router } from '@angular/router';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'projet-coloc-front';


  utilisateurConnecte: UtilisateurDTO;
  



  filtreVille: string;

  constructor(private rechercheLogementService: RechercheLogementService, public router: Router) {
   this.utilisateurConnecte = new UtilisateurDTO;
   //this.utilisateurConnecte.typeDeCompte="locataire";
   this.utilisateurConnecte.id=2;
   this.utilisateurConnecte.typeDeCompte="proprietaire";
  }

  search(ville: string) {
    this.rechercheLogementService.findByVille(ville);
 
  }

  //getCoordVille(){
  //  this.mapService.getCoordVille(this.filtreVille);
  //}

  isHomeRoute() {
    return this.router.url === '/home';
  }
 
}
