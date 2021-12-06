import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { LogementHttpService } from '../logement/logement-http.service';
import { Logement, Proprietaire } from '../model';
import { ProprietaireHttpService } from './proprietaire-http.service';

@Component({
  selector: 'app-proprietaire',
  templateUrl: './proprietaire.component.html',
  styleUrls: ['./proprietaire.component.scss']
})
export class ProprietaireComponent implements OnInit {

  proprietaireForm: Proprietaire = new Proprietaire();
  logements: Array<Logement> = new Array<Logement>();
  civilites: Array<String> = new Array<String>();
  idLogements: Array<number> = new Array<number>();

  constructor(private appConfig: AppConfigService, private proprietaireService: ProprietaireHttpService, private logementService: LogementHttpService, private activatedRoute: ActivatedRoute) {
    this.loadCivilites();
  }

   ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
        const id = p['id'];
        this.proprietaireService.findById(id).subscribe(proprietaire => {
          this.proprietaireForm = proprietaire;
        });
        this.logementService.findAllByIdProprietaire(id).subscribe(logs => {
          this.logements = logs;
          console.log(logs);
        }, err => console.log(err));
    })
        
  }
  loadCivilites() {
    this.appConfig.findAllCivilites().subscribe(resp => {
      this.civilites = resp;
    }, err => console.log(err));
  }

  list(): Array<Proprietaire> {
    return this.proprietaireService.findAll();
  }

  add() {
    this.proprietaireForm = new Proprietaire();
  }

  edit(id: number) {
    this.proprietaireService.findById(id).subscribe(resp => {
      this.proprietaireForm = resp;
      this.idLogements = new Array <number>();
      this.proprietaireForm.logements.forEach(logement => {
        this.idLogements.push(logement.id);
      });
      this.proprietaireForm.logements = new Array <Logement>();
    }, err => console.log(err));
  }

  save() {
    this.idLogements.forEach(id => {
      this.proprietaireForm.logements.push(new Logement(id));
    });
      this.proprietaireService.modify(this.proprietaireForm);
  }

  cancel() {
    this.proprietaireForm = null;
  }

  delete(id: number) {
    this.proprietaireService.deleteById(id);
  }

}
