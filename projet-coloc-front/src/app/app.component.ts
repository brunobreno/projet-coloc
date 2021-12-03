import { Component } from '@angular/core';
import { Logement, Proprietaire, Utilisateur } from './model';
import { Locataire } from './model';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { RechercheLogementService } from './recherche-logement/recherche-logement.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'projet-coloc-front';
  userConnect:string = 'Locataire';
  //userConnect:Proprietaire = new Proprietaire();
  //userConnect:Utilisateur =  null;
 // userConnect:Locataire;

  filtre: string;

  constructor(private rechercheLogementService: RechercheLogementService) {}

  search(ville:string) {
    console.log('passage par search')
    this.rechercheLogementService.findByVilleWithCom(ville);
    //return this.rechercheLogementService.findAll();
  }
 
}
