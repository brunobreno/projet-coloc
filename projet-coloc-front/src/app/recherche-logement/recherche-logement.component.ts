import { Component, OnInit } from '@angular/core';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';


import { faCouch } from '@fortawesome/free-solid-svg-icons';
import { faSmoking } from '@fortawesome/free-solid-svg-icons';
import { faCat } from '@fortawesome/free-solid-svg-icons';
import { faParking } from '@fortawesome/free-solid-svg-icons';
import { Logement, Commodite, Locataire } from '../model';


@Component({
  selector: 'app-recherche-logement',
  templateUrl: './recherche-logement.component.html',
  styleUrls: ['./recherche-logement.component.scss']
})
export class RechercheLogementComponent implements OnInit {
  faCouch = faCouch;
  faSmoking = faSmoking;
  faCat = faCat;
  faParking = faParking;

  carousselId: number = 1;

  ville: string;
  logements: Array<Logement> = new Array<Logement>();
  locatairesLogement: Array<Locataire> = new Array<Locataire>();

  filtre: string;

  tri: number;

  values = [
    { id: 3432, name: "Prix Croissant" },
    { id: 3442, name: "Prix Décroissant" },
    { id: 3452, name: "Surface Croissante" },
    { id: 3462, name: "Surface Décroissante" }
  ];

  constructor(private rechercheLogementService: RechercheLogementService) {
    
   }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    console.log("passage par list")
    this.logements = this.rechercheLogementService.logements;
    this.trierLogement();
    return this.logements;
  }


  nbLocataires(id: number): number{
    this.rechercheLogementService.findLocatairesByLogement(id);
    return this.rechercheLogementService.locatairesLogement.length;
  }
  
  /*findLocataireByLogement(id: number){
    console.log("passage par findLocataireByLogement")
    this.rechercheLogementService.findLocatairesByLogement(id);
    this.locatairesLogement = this.rechercheLogementService.locatairesLogement;
  }*/

  trierLogement() {
    console.log("passage par trier")
    if (this.tri == 3442) {
      this.logements.sort(function (a, b) {
        return b.loyer - a.loyer;
      });
    }
    else if (this.tri == 3452) {
      this.logements.sort(function (a, b) {
        return a.surface - b.surface;
      });
    }
    else if (this.tri == 3462) {
      this.logements.sort(function (a, b) {
        return b.surface - a.surface;
      });
    }
    else {
      this.logements.sort(function (a, b) {
        return a.loyer - b.loyer;
      });
    }

  }


  onChange($event: any) {
    this.tri = $event.target.value;
    console.log("passage par onChange")
   // this.trierLogement();
  }

  

  search(ville: string) {
    this.ville = ville;
    console.log("passage par search (recherche logement)")
    this.rechercheLogementService.findByVilleWithCom(ville);
  }


}
