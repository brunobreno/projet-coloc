import { Component, OnInit } from '@angular/core';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';


import { faCouch } from '@fortawesome/free-solid-svg-icons';
import { faSmoking } from '@fortawesome/free-solid-svg-icons';
import { faCat } from '@fortawesome/free-solid-svg-icons';
import { faParking } from '@fortawesome/free-solid-svg-icons';
import { Logement,Commodite } from '../model';


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

  carousselId:number = 1;

  ville:string;
  logementWithCom:Logement;

  constructor(private rechercheLogementService: RechercheLogementService) { }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    return this.rechercheLogementService.findAll();
  }


  caroussel(): number{
    return this.carousselId;
  }


}
