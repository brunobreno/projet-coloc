import { Component, OnInit } from '@angular/core';
import { RechercheLogementService } from '../recherche-logement/recherche-logement.service';


import { faCouch } from '@fortawesome/free-solid-svg-icons';
import { faSmoking } from '@fortawesome/free-solid-svg-icons';
import { faCat } from '@fortawesome/free-solid-svg-icons';
import { faParking } from '@fortawesome/free-solid-svg-icons';
import { Logement } from '../model';


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

  ville:string;

  constructor(private rechercheLogementService: RechercheLogementService) { }

  ngOnInit(): void {
  }

  list(): Array<Logement> {
    return this.rechercheLogementService.findAll();
  }

  search(ville:string): Array<Logement> {
    this.rechercheLogementService.findByVille(ville);
    return this.rechercheLogementService.findAll();
  }


}
