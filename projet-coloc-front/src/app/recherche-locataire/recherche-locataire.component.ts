import { Component, OnInit } from '@angular/core';
import { Locataire } from '../model';
import { RechercheLocataireService } from './recherche-locataire.service';

@Component({
  selector: 'app-recherche-locataire',
  templateUrl: './recherche-locataire.component.html',
  styleUrls: ['./recherche-locataire.component.scss']
})
export class RechercheLocataireComponent implements OnInit {

  locataires: Array<Locataire>;

  constructor(private rechercheLocataireService: RechercheLocataireService) {
    rechercheLocataireService.loadLocataires().subscribe(resp => {
      this.locataires = resp;
    }, err => console.log(err))
   }

  ngOnInit(): void {
  }

}
