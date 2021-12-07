import { Component, OnInit } from '@angular/core';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';
import { MatSliderModule } from '@angular/material/slider';

import { faCouch } from '@fortawesome/free-solid-svg-icons';
import { faSmoking } from '@fortawesome/free-solid-svg-icons';
import { faCat } from '@fortawesome/free-solid-svg-icons';
import { faParking } from '@fortawesome/free-solid-svg-icons';
import { Logement, Commodite, filtre } from '../model';
import { MapHttpService } from '../map/map-http.service';
import { analyzeAndValidateNgModules } from '@angular/compiler';



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

  logementsPourFiltre:Array<Logement> = new Array<Logement>();
  filtreTypeLogement: string = null;
  filtreLoyer: number = null;
  filtreOccupant:number = null;
  listeFiltreTypeLogement: Array<string> = new Array<string>();
  logementsFiltreType: Array<Logement> = new Array<Logement>();
  logementsFiltreLoyer: Array<Logement> = new Array<Logement>();
  logementsFiltreOccupant: Array<Logement> = new Array<Logement>();

  cp:string;
  ville:string;
  num:number;
  voie:string;
  coordonneesAdresses: Array<Array<number>> = new Array<Array<number>>();


  constructor(private rechercheLogementService: RechercheLogementService, private mapService: MapHttpService) {
    
  }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    return this.rechercheLogementService.findAll();
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

  filtreLogement(){
    this.filtreLogementType();
    this.filtreLogementLoyer();
    this.filtreLogementOccupant();
    this.resetListeFiltre();
    this.getCoordonnesLogements();
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
    if(this.listeFiltreTypeLogement.length > 0) {
      this.logementsPourFiltre = this.logementsFiltreType;
    }
    else{
      this.logementsPourFiltre = this.rechercheLogementService.logementsByVille;
    }

    if(this.filtreLoyer == null){
      this.rechercheLogementService.logements =  this.logementsPourFiltre;
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
    if(this.filtreLoyer == null && this.logementsFiltreType.length == 0) {
      this.logementsPourFiltre = this.rechercheLogementService.logementsByVille;
    }
    else if (this.listeFiltreTypeLogement.length == 0){
      this.logementsPourFiltre = this.logementsFiltreLoyer;
    }
    else{
      this.logementsPourFiltre = this.logementsFiltreType;
    }
    if(this.filtreOccupant == null){
      this.rechercheLogementService.logements =  this.logementsPourFiltre;
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
    for(let log of this.rechercheLogementService.logements){
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
} 
