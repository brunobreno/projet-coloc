import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppConfigService } from './app-config.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { LocataireComponent } from './locataire/locataire.component';
import { LocataireHttpService } from './locataire/locataire-http.service';
import { AjoutLogementComponent } from './ajout-logement/ajout-logement.component';
import { LogementComponent } from './logement/logement.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { DescriptionLogementComponent } from './description-logement/description-logement.component';


@NgModule({
  declarations: [
    AppComponent,
    ProfilLocataireComponent,
    LocataireComponent,
    AjoutLogementComponent,
    LogementComponent,
    DescriptionLogementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NoopAnimationsModule
  ],
  providers: [AppConfigService,LocataireHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
