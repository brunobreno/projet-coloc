import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppConfigService } from './app-config.service';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {MatIconModule} from '@angular/material/icon'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TypeofPipe } from './typeof.pipe';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { LocataireComponent } from './locataire/locataire.component';
import { LocataireHttpService } from './locataire/locataire-http.service';

@NgModule({
  declarations: [
    AppComponent,
    TypeofPipe,
    LocataireComponent
    RechercheLogementComponent
    ProfilLocataireComponent,
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    MatIconModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppConfigService,LocataireHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
