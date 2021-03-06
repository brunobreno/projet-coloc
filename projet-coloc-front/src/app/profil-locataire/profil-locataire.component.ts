import { Component, OnInit } from '@angular/core';
import { Dossier, Locataire } from '../model';
import { AppConfigService } from '../app-config.service';
import { ProfilLocataireHttpService } from './profil-locataire-http.service';
import { LocataireHttpService } from '../locataire/locataire-http.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profil-locataire',
  templateUrl: './profil-locataire.component.html',
  styleUrls: ['./profil-locataire.component.scss']
})
export class ProfilLocataireComponent implements OnInit {

  locataireForm: Locataire;
  locataire: Locataire;
  civilites: Array<string> = new Array<string>();
  situations: Array<string> = new Array<string>();
  // situationLoc: string;

  constructor(private appConfig: AppConfigService, private locataireService: LocataireHttpService, private activatedRoute: ActivatedRoute) {
    this.loadCivilites();
    this.loadSituations();
    // this.loadTestLocataireForm(6);
    // this.situationLoc = this.locataireForm.situation;
   }

  ngOnInit(): void {
    this.locataireForm = new Locataire();
    this.locataireForm.dossier = new Dossier();
    this.activatedRoute.params.subscribe(l => {
      const id = l['id'];
      this.locataireService.findById(id).subscribe(loc => {
      this.locataireForm = loc;
      this.locataire=loc;
      console.log(this.locataireForm);
      });
  })

  }

  // loadTestLocataireForm(id: number){
  //   this.locataireForm = new Locataire();
  //   this.locataireForm.dossier = new Dossier();
  //   this.locataireService.findById(id).subscribe(resp => {
  //   this.locataireForm = resp;
  //   })
  // }

  loadCivilites(){
    this.appConfig.findAllCivilites().subscribe(resp => {
      this.civilites = resp;
    }, err => console.log(err));
  }

  loadSituations(){
    this.appConfig.findAllSituations().subscribe(resp => {
      this.situations = resp;
    }, err => console.log(err));
  }

  save() {
    this.locataireService.modify(this.locataireForm); 
  }

  edit(id: number) {
    this.locataireService.findById(id).subscribe(resp => {
      this.locataireForm = resp;
    }, err => console.log(err));
  }


}
