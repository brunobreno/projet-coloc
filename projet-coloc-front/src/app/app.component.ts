import { Component } from '@angular/core';
import { MapHttpService } from './map/map-http.service';
import { Logement, Proprietaire, Utilisateur } from './model';
import { Locataire } from './model';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { RechercheLogementService } from './recherche-logement/recherche-logement.service';

// import des incons fontawesome
import { faCalendarAlt } from '@fortawesome/free-solid-svg-icons';
import { faMoneyBill } from '@fortawesome/free-solid-svg-icons';
import { faUsers } from '@fortawesome/free-solid-svg-icons';
import { faExpandAlt } from '@fortawesome/free-solid-svg-icons';
import { faCommentAlt } from '@fortawesome/free-solid-svg-icons';
import { faFileDownload } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'projet-coloc-front';
  userConnect:string = 'Locataire';

  //icons fontawesome
  faCalendar=faCalendarAlt;
  faMoneyBill=faMoneyBill;
  faUsers=faUsers;
  faExpandAlt=faExpandAlt;
  faCommentAlt=faCommentAlt;
  faFileDownload=faFileDownload;


  filtre: string;

  constructor(private rechercheLogement: RechercheLogementComponent, private rechercheLogementService: RechercheLogementService, private mapService:MapHttpService) {}

  search(ville:string) {
    console.log('passage par search')
    this.rechercheLogement.search(ville);
    //return this.rechercheLogementService.findAll();
  }

}
