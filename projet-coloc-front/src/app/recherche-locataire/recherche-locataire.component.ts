import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AgePipe } from '../age.pipe';
import { AppConfigService } from '../app-config.service';
import { Locataire, Utilisateur } from '../model';
import { RechercheLocataireService } from './recherche-locataire.service';


@Component({
  selector: 'app-recherche-locataire',
  templateUrl: './recherche-locataire.component.html',
  styleUrls: ['./recherche-locataire.component.scss']
})
export class RechercheLocataireComponent implements OnInit {

  locataires: Array<Locataire>;
  locatairesFiltres : Array<Locataire>;
  triCivilite: string;
  ageMax: number;
  ageMin: number;
  triRecherche: string;
  utilisateurConnecte: Utilisateur;

  constructor(private rechercheLocataireService: RechercheLocataireService, private appConfig: AppConfigService, private router:Router) {
    rechercheLocataireService.loadLocataires().subscribe(resp => {
      this.locataires = resp;
      if(this.appConfig.utilisateurConnecte){
        this.locatairesFiltres = this.locataires.filter(loc => this.appConfig.utilisateurConnecte.id == loc.id);
      } else {
        this.locatairesFiltres = this.locataires;
      }
    }, err => console.log(err))
   }

  ngOnInit(): void {
  }

  filtrer($event: any) {
    this.locatairesFiltres = this.locataires;
    if(this.triCivilite == "femme"){
      this.locatairesFiltres = this.locatairesFiltres.filter(loc => loc.civ == "Mme");
    }
    if(this.triCivilite == "homme"){
      this.locatairesFiltres = this.locatairesFiltres.filter(loc => loc.civ == "Mr");
    }
    if(this.triRecherche == "enRecherche"){
      this.locatairesFiltres = this.locatairesFiltres.filter(loc => loc.recherche == true);
    }
    if(this.ageMin){
      this.locatairesFiltres = this.locatairesFiltres.filter(loc => this.calculAge(loc.dateDeNaissance) >= this.ageMin);
    }
    if(this.ageMax){
      this.locatairesFiltres = this.locatairesFiltres.filter(loc => this.calculAge(loc.dateDeNaissance) < this.ageMax);
    }
  }

  calculAge(value: string): number {
    let dtValue: Date = new Date(value);
    let dtJour: Date = new Date();
    let age = dtJour.getFullYear() - dtValue.getFullYear();
    return age;
  }

  resetFilter(){
    this.ageMax = null;
    this.ageMin = null;
    this.triCivilite = null;
    this.triRecherche = null;
    this.filtrer(null);
  }

  nouveauMessage(id:number){
    this.router.navigate(["./messagerie-nouveau/", id]);
  }
}
