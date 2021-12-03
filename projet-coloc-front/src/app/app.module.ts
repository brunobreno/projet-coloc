import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppConfigService } from './app-config.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { LocataireComponent } from './locataire/locataire.component';
import { LocataireHttpService } from './locataire/locataire-http.service';
import { LogementComponent } from './logement/logement.component';

@NgModule({
  declarations: [
    AppComponent,
    ProprietaireComponent,
    ProfilLocataireComponent,
    LocataireComponent,
    LogementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppConfigService,LocataireHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
