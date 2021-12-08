import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LogementHttpService } from '../logement/logement-http.service';
import { Logement, Proprietaire, UtilisateurDTO } from '../model';
import { ProprietaireHttpService } from '../proprietaire/proprietaire-http.service';

@Component({
  selector: 'app-logement-proprietaire',
  templateUrl: './logement-proprietaire.component.html',
  styleUrls: ['./logement-proprietaire.component.scss']
})
export class LogementProprietaireComponent implements OnInit {

  logements: Array<Logement> = new Array<Logement>();
  utilisateurConnecte= new UtilisateurDTO;
  proprietaire: Proprietaire;

  constructor(private activatedRoute: ActivatedRoute,
    private logementService: LogementHttpService,
    private proprietaireService : ProprietaireHttpService) {
      this.utilisateurConnecte.id=1;
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(p => {
      const id = p['id'];
      this.logementService.findAllByIdProprietaire(id).subscribe(logs => {
        this.logements = logs;
        console.log(logs);
      }, err => console.log(err));
      this.proprietaireService.findById(id).subscribe(proprio => {
        this.proprietaire = proprio;
        console.log(proprio);
      }, err => console.log(err));
    })
  }

  list(){
    return this.logements;
  }

}
