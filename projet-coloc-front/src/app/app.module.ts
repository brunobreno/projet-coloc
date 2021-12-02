import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppConfigService } from './app-config.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';

@NgModule({
  declarations: [
    AppComponent,
    ProprietaireComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AppConfigService],
  bootstrap: [AppComponent]
})
export class AppModule { }
