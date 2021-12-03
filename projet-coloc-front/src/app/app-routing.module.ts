import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LogInComponent } from './log-in/log-in.component';
import { RechercheLocataireComponent } from './recherche-locataire/recherche-locataire.component';
import { RedirectComponent } from './redirect/redirect.component';

const routes: Routes = [
  {path: "login", component: LogInComponent},
  {path: "inscription", component: InscriptionComponent},
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "", redirectTo: "profilLocataire", pathMatch: "full" },
  { path: "rechercheLocataires", component: RechercheLocataireComponent },
  { path: "**", component: RedirectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
