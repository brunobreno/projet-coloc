import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Proprietaire } from '../model';
import { ProprietaireHttpService } from './proprietaire-http.service';

@Component({
  selector: 'app-proprietaire',
  templateUrl: './proprietaire.component.html',
  styleUrls: ['./proprietaire.component.scss']
})
export class ProprietaireComponent implements OnInit {

  proprietaireForm: Proprietaire = null;
  civilites: Array<String> = new Array<String>();

  constructor(private appConfig: AppConfigService, private proprietaireService: ProprietaireHttpService, private activatedRoute: ActivatedRoute) {
    this.loadCivilites(); 
  }

   ngOnInit() {
    this.activatedRoute.params.subscribe(p => {
        const id = p['id'];
        this.proprietaireService.findById(id).subscribe(proprietaire => {
          this.proprietaireForm = proprietaire;
        })
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
    }, err => console.log(err));
  }

  save() {
    if (!this.proprietaireForm.id) {
      this.proprietaireService.create(this.proprietaireForm);
    } else {
      this.proprietaireService.modify(this.proprietaireForm);
    }
    this.proprietaireForm = null;
  }

  cancel() {
    this.proprietaireForm = null;
  }

  delete(id: number) {
    this.proprietaireService.deleteById(id);
  }

}
