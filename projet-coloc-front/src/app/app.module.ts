import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppConfigService } from './app-config.service';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatIconModule} from '@angular/material/icon'; 
import {CrystalLightboxModule} from '@crystalui/angular-lightbox';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';
import { TypeofPipe } from './typeof.pipe';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { LocataireComponent } from './locataire/locataire.component';
import { LocataireHttpService } from './locataire/locataire-http.service';
import { LogInComponent } from './log-in/log-in.component';
import { LogInService } from './log-in/log-in.service';
import { InscriptionComponent } from './inscription/inscription.component';
import { InscriptionService } from './inscription/inscription.service';
import { RechercheLocataireComponent } from './recherche-locataire/recherche-locataire.component';
import { RechercheLocataireService } from './recherche-locataire/recherche-locataire.service';
import { AgePipe } from './age.pipe';
import { RedirectComponent } from './redirect/redirect.component';
import { LogementComponent } from './logement/logement.component';
import { AjoutLogementComponent } from './ajout-logement/ajout-logement.component';
import { DescriptionLogementComponent } from './description-logement/description-logement.component';
import { AjoutLogementHttpService } from './ajout-logement/ajout-logement-http.service';
import { HomePageComponent } from './home-page/home-page.component';
import { HomePageService } from './home-page/home-page.service';
import { MessagerieComponent } from './messagerie/messagerie.component';
import { MessagerieService } from './messagerie/messagerie.service';
import { MessagerieNouveauContactComponent } from './messagerie-nouveau-contact/messagerie-nouveau-contact.component';
import { MessagerieNouveauContactService } from './messagerie-nouveau-contact/messagerie-nouveau-contact.service';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { DescriptionLogementService } from './description-logement/description-logement.service';
import { ChambreComponent } from './chambre/chambre.component';
import { MapComponent } from './map/map.component';
import { MarkerService } from './map/marker.service';
import { MapHttpService } from './map/map-http.service';
import { LogementProprietaireComponent } from './logement-proprietaire/logement-proprietaire.component';


@NgModule({
  declarations: [
    AppComponent,
    LocataireComponent,
    RechercheLogementComponent,
    ProfilLocataireComponent,
    TypeofPipe,
    LogInComponent,
    InscriptionComponent,
    RechercheLocataireComponent,
    RedirectComponent,
    AgePipe,
    ProprietaireComponent,
    LogementComponent,
    DescriptionLogementComponent,
    AjoutLogementComponent,
    ChambreComponent,
    DescriptionLogementComponent,
    HomePageComponent,
    MessagerieComponent,
    MessagerieNouveauContactComponent,
    MapComponent,
    LogementProprietaireComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    MatIconModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    IvyCarouselModule,
    CrystalLightboxModule
    //NoopAnimationsModule
  ],
 
  providers: [
    AppConfigService, 
    LocataireHttpService, 
    LogInService, 
    InscriptionService, 
    RechercheLocataireService, 
    AjoutLogementHttpService,
    DescriptionLogementService,
    RechercheLogementComponent,
    HomePageService, 
    MessagerieService, 
    MessagerieNouveauContactService,
    MapHttpService, 
    MarkerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
