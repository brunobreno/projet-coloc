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
import { LogInComponent } from './log-in/log-in.component';
import { LogInService } from './log-in/log-in.service';
import { InscriptionComponent } from './inscription/inscription.component';
import { InscriptionService } from './inscription/inscription.service';

@NgModule({
  declarations: [
    AppComponent,
    RechercheLogementComponent,
    ProfilLocataireComponent
    LocataireComponent,
    TypeofPipe,
    LogInComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppConfigService,LocataireHttpService, LogInService, InscriptionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
