import { Component, OnInit } from '@angular/core';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';
import { MatSliderModule } from '@angular/material/slider';

import { faCouch } from '@fortawesome/free-solid-svg-icons';
import { faSmoking } from '@fortawesome/free-solid-svg-icons';
import { faCat } from '@fortawesome/free-solid-svg-icons';
import { faParking } from '@fortawesome/free-solid-svg-icons';
import { Logement, Commodite, Locataire } from '../model';
import { MapHttpService } from '../map/map-http.service';



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

  logementWithCom: Logement;

  logementsPourFiltre: Array<Logement> = new Array<Logement>();
  filtreTypeLogement: string = null;
  filtreLoyer: number = null;
  filtreOccupant: number = null;
  listeFiltreTypeLogement: Array<string> = new Array<string>();
  logementsFiltreType: Array<Logement> = new Array<Logement>();
  logementsFiltreLoyer: Array<Logement> = new Array<Logement>();
  logementsFiltreOccupant: Array<Logement> = new Array<Logement>();

  cp: string;
  ville: string;
  num: number;
  voie: string;
  coordonneesAdresses: Array<Array<number>> = new Array<Array<number>>();
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
  constructor(private rechercheLogementService: RechercheLogementService, private mapService: MapHttpService) {

  }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    console.log("passage par list")
    this.logements = this.rechercheLogementService.logements;
    this.trierLogement();
    return this.logements;
  }


  nbLocataires(id: number): number {
    this.rechercheLogementService.findLocatairesByLogement(id);
    return this.rechercheLogementService.locatairesLogement.length;
  }
  onChangeFiltreType($event: any) {
    this.filtreTypeLogement = $event.target.value;

    if (this.listeFiltreTypeLogement.includes(this.filtreTypeLogement)) {
      let indexFiltre = this.listeFiltreTypeLogement.indexOf(this.filtreTypeLogement);
      this.listeFiltreTypeLogement.splice(indexFiltre, 1);
    } else {
      this.listeFiltreTypeLogement.push(this.filtreTypeLogement);
    }

    this.filtreLogement();
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
  filtreLogement() {
    this.filtreLogementType();
    this.filtreLogementLoyer();
    this.filtreLogementOccupant();
    this.resetListeFiltre();
    this.getCoordonnesLogements();
  }



  onChange($event: any) {
    this.tri = $event.target.value;
    console.log("passage par onChange")
    // this.trierLogement();
  }



  search(ville: string) {
    this.ville = ville;
    console.log("passage par search (recherche logement)")
    this.rechercheLogementService.findByVille(ville);
  }


}
filtreLogementType(){
  this.logementsPourFiltre = this.rechercheLogementService.logementsByVille;

  if (this.listeFiltreTypeLogement.length == 0) {
    this.rechercheLogementService.logements = this.rechercheLogementService.logementsByVille;
  }
  else {
    // this.rechercheLogementService.findByVilleWithCom(this.rechercheLogementService.filtreVille);
    for (let log of this.logementsPourFiltre) {
      for (let f of this.listeFiltreTypeLogement) {
        if (log.typeLogement == f) {
          this.logementsFiltreType.push(log);
          // console.log(log);
        }
      }
    }
    this.rechercheLogementService.logements = this.logementsFiltreType;
    // console.log(this.logementsFiltreType);
  }
}


filtreLogementLoyer() {
  if (this.listeFiltreTypeLogement.length > 0) {
    this.logementsPourFiltre = this.logementsFiltreType;
  }
  else {
    this.logementsPourFiltre = this.rechercheLogementService.logementsByVille;
  }

  if (this.filtreLoyer == null) {
    this.rechercheLogementService.logements = this.logementsPourFiltre;
  }
  else {
    for (let log of this.logementsPourFiltre) {
      // console.log(log.loyer);
      // console.log(this.filtreLoyer);
      if (log.loyer <= this.filtreLoyer) {
        this.logementsFiltreLoyer.push(log);
        // console.log(this.logementsFiltreLoyer.length);
        this.rechercheLogementService.logements = this.logementsFiltreLoyer;
      }
      this.rechercheLogementService.logements = this.logementsFiltreLoyer;
    }
    this.rechercheLogementService.logements = this.logementsFiltreLoyer;
  }
}

filtreLogementOccupant() {
  if (this.filtreLoyer == null && this.logementsFiltreType.length == 0) {
    this.logementsPourFiltre = this.rechercheLogementService.logementsByVille;
  }
  else if (this.listeFiltreTypeLogement.length == 0) {
    this.logementsPourFiltre = this.logementsFiltreLoyer;
  }
  else {
    this.logementsPourFiltre = this.logementsFiltreType;
  }
  if (this.filtreOccupant == null) {
    this.rechercheLogementService.logements = this.logementsPourFiltre;
  }
  else {
    for (let log of this.logementsPourFiltre) {
      if (log.nChambre <= this.filtreOccupant) {
        this.logementsFiltreOccupant.push(log);
      }
    }
    this.rechercheLogementService.logements = this.logementsFiltreOccupant;
  }
}

resetListeFiltre(){
  this.logementsFiltreType = new Array<Logement>();
  this.logementsFiltreLoyer = new Array<Logement>();
  this.logementsFiltreOccupant = new Array<Logement>();
  this.logementsPourFiltre = new Array<Logement>();
}



caroussel(): number {
  return this.carousselId;
}


getCoordonnesLogements(){
  for (let log of this.rechercheLogementService.logements) {
    log.localisation.codePostal = this.cp;
    log.localisation.ville = this.ville;
    log.localisation.num = this.num;
    log.localisation.voie = this.voie;

    console.log('boucle getCoordLogments ' + log);
    // this.voie = this.voie.replace(/ /g, '+');

    // this.mapService.getCoordLogements(this.num,this.voie,this.cp,this.ville);
    // this.coordonneesAdresses.push(this.mapService.resultat.features[0].geometry.coordinates);
    // console.log("boucle for" + this.coordonneesAdresses);
  }
}
