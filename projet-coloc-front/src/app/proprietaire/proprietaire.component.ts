import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { CommoditeHttpService } from '../commodite-http.service';
import { LogementHttpService } from '../logement/logement-http.service';
import { Commodite, Logement, Proprietaire } from '../model';
import { RegleHttpService } from '../regle-http.service';
import { ProprietaireHttpService } from './proprietaire-http.service';

@Component({
  selector: 'app-proprietaire',
  templateUrl: './proprietaire.component.html',
  styleUrls: ['./proprietaire.component.scss']
})
export class ProprietaireComponent implements OnInit {

  proprietaireForm: Proprietaire = new Proprietaire();
  proprietaire: Proprietaire;
  logements: Array<Logement> = new Array<Logement>();
  logementForm: Logement;
  logement: Logement;
  civilites: Array<String> = new Array<String>();
  idLogements: Array<number> = new Array<number>();
  commodites: Array<Commodite> = new Array<Commodite>();

  constructor(private appConfig: AppConfigService, private proprietaireService: ProprietaireHttpService, private logementService: LogementHttpService, private commoditeService: CommoditeHttpService, private regleService: RegleHttpService, private activatedRoute: ActivatedRoute) {
    this.loadCivilites();
    this.loadCommodites();
    this.loadRegles();
  }

   ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
        const id = p['id'];
        this.proprietaireService.findById(id).subscribe(prop => {
          this.proprietaireForm = prop;
          this.proprietaire = prop;
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

  loadCommodites() {
    return this.commoditeService.findAll();
  }

  loadRegles() {
    return this.regleService.findAll();
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
    }, err => console.log(err));
  }

  editLogement(id: number) {
    this.logementService.findById(id).subscribe(resp => {
      this.logementForm = resp;
      this.logement = resp;
      this.idLogements = new Array <number>();
    }, err => console.log(err));
  }

  save() {
    this.idLogements.forEach(id => {
      this.proprietaireForm.logements.push(new Logement(id));
    });
      this.proprietaireService.modify(this.proprietaireForm);
      this.proprietaire=this.proprietaireForm;
  }

  saveLogement() {
      this.logementService.modify(this.logementForm);
      this.logement=this.logementForm;
      this.save();
  }

  cancel() {
    this.proprietaireForm = null;
  }

  cancelLogement() {
    this.logementForm = null;
  }

  delete(id: number) {
    this.proprietaireService.deleteById(id);
  }

  deleteLogement(id: number) {
    this.logementService.deleteById(id);
  }

//   changeCheck(): void {        
//     for (let item = 0; item < this.logement.commodites.length; item++) {
//         this.logement.commodites[item].checked = true;
//     }
// }

}
