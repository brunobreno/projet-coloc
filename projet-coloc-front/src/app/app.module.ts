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

@NgModule({
  declarations: [
    AppComponent,
    TypeofPipe,
    RechercheLogementComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    MatIconModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }
