import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Logement, Localisation, Locataire, Chambre, Photo } from '../model';
import { DescriptionLogementService } from './description-logement.service';
import { AppComponent } from '../app.component';
import { ChambreService } from '../chambre/chambre.service';
import { MapHttpService } from '../map/map-http.service';
import { MarkerService } from '../map/marker.service';
import { MapComponent } from '../map/map.component';
import { LocataireHttpService } from '../locataire/locataire-http.service';



@Component({
  selector: 'app-description-logement',
  templateUrl: './description-logement.component.html',
  styleUrls: ['./description-logement.component.scss']
})
export class DescriptionLogementComponent implements OnInit {

  logement: Logement;
  localisation: Localisation;
  locataires: Array<Locataire> = new Array<Locataire>();
  chambres: Array<Chambre> = new Array<Chambre>();
  photos: Array<Photo> = new Array<Photo>();
  

  faMoneyBill=this.appConfig.faMoneyBill;
  faUsers=this.appConfig.faUsers;
  faExpandAlt=this.appConfig.faExpandAlt;
  faCommentAlt=this.appConfig.faCommentAlt;
  faFileDownload=this.appConfig.faFileDownload;
  faCouch=this.appConfig.faCouch;
  faCalendar=this.appConfig.faCalendar;


  

  constructor(private appConfig: AppConfigService, private descriptionService: DescriptionLogementService, 
    private chambreService: ChambreService, private locataireService: LocataireHttpService, 
    private activatedRoute: ActivatedRoute) { 
     }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(p => {
      const id = p['id'];
      this.descriptionService.findById(id).subscribe(logement => {
        this.logement = logement;
      })
      this.locataireService.findAllByIdLogement(id).subscribe(locataires => {
        this.locataires = locataires;
      })
      this.chambreService.findByLogement(id).subscribe(chambres => {
        this.chambres = chambres;
      })
     
    });
    //this.mapComponent.getCoordLogement();
  }



}
