import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LogInComponent } from './log-in/log-in.component';
import { RechercheLocataireComponent } from './recherche-locataire/recherche-locataire.component';
import { RedirectComponent } from './redirect/redirect.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';

const routes: Routes = [
  {path: "login", component: LogInComponent},
  {path: "inscription", component: InscriptionComponent},
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "rechercheLocataires", component: RechercheLocataireComponent },
  { path: "**", component: RedirectComponent}
  {path: "proprietaire/:id", component: ProprietaireComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
