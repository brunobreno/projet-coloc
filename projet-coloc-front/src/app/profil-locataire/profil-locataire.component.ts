import { Component, OnInit } from '@angular/core';
import { Dossier, Locataire } from '../model';
import { AppConfigService } from '../app-config.service';
import { ProfilLocataireHttpService } from './profil-locataire-http.service';
import { LocataireHttpService } from '../locataire/locataire-http.service';

@Component({
  selector: 'app-profil-locataire',
  templateUrl: './profil-locataire.component.html',
  styleUrls: ['./profil-locataire.component.scss']
})
export class ProfilLocataireComponent implements OnInit {

  locataireForm: Locataire = null;
  civilites: Array<string> = new Array<string>();
  situations: Array<string> = new Array<string>();

  constructor(private appConfig: AppConfigService, private locataireService: LocataireHttpService) {
    this.loadCivilites();
    this.loadSituations();
    
    this.loadTestLocataireForm(5);
   }

  ngOnInit(): void {
  }

  loadTestLocataireForm(id: number){
    this.locataireForm = new Locataire();
    this.locataireForm.dossier = new Dossier();
    this.locataireService.findById(id).subscribe(resp => {
      this.locataireForm = resp;

      
    })
  }

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


}
