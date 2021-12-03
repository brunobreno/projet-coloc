import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Logement, Localisation, Commodite, Regle, Chambre } from '../model';
import { LogementHttpService } from '../logement/logement-http.service';


@Component({
  selector: 'app-ajout-logement',
  templateUrl: './ajout-logement.component.html',
  styleUrls: ['./ajout-logement.component.scss']
})
export class AjoutLogementComponent implements OnInit {

  logementForm: Logement = null;
  ajout: boolean = false;
  liste: Array<number>;

  constructor(private appConfig: AppConfigService, private logementService: LogementHttpService) {
    this.logementForm = new Logement();
    this.logementForm.localisation = new Localisation();
    this.logementForm.commodites = new Array<Commodite>();
    this.logementForm.regles = new Array<Regle>();
    this.logementForm.chambres = new Array<Chambre>();
  }

  ngOnInit(): void {
  }

  addCommodite(id:number){
    this.logementForm.commodites.push(new Commodite(id))
  }

  addRegle(id:number){
    this.logementForm.regles.push(new Regle(id))
  }

  listChambre(): Array<number>{
    this.liste = new Array<number>();
    for(let i=1;i<this.logementForm.nChambre+1;i++) {
      this.liste.push(i);
    }

    return this.liste;
  }

  save() {
    this.logementService.create(this.logementForm);
    this.ajout = true;
  }
   

}
