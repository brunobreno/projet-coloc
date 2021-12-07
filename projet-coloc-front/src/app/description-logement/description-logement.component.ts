import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { Logement, Localisation, Locataire, Chambre, Photo } from '../model';
import { DescriptionLogementService } from './description-logement.service';
import { AppComponent } from '../app.component';
import { ChambreService } from '../chambre/chambre.service';



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
  


  faCalendar=this.appComponent.faCalendar;
  faMoneyBill=this.appComponent.faMoneyBill;
  faUsers=this.appComponent.faUsers;
  faExpandAlt=this.appComponent.faExpandAlt;
  faCommentAlt=this.appComponent.faCommentAlt;
  faFileDownload=this.appComponent.faFileDownload;

  

  constructor(private appConfig: AppConfigService, private descriptionService: DescriptionLogementService, 
    private chambreService: ChambreService, 
    private appComponent: AppComponent, 
    private activatedRoute: ActivatedRoute) { 
     }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(p => {
      const id = p['id'];
      this.descriptionService.findById(id).subscribe(logement => {
        this.logement = logement;
      })
      this.descriptionService.findWithLocataire(id).subscribe(locataires => {
        this.locataires = locataires;
      })
      this.chambreService.findByLogement(id).subscribe(chambres => {
        this.chambres = chambres;
      })
     
      
  })
  }



}
