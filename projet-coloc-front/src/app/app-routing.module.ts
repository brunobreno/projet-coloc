import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjoutLogementComponent } from './ajout-logement/ajout-logement.component';
import { DescriptionLogementComponent } from './description-logement/description-logement.component';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LogInComponent } from './log-in/log-in.component';
import { RechercheLocataireComponent } from './recherche-locataire/recherche-locataire.component';
import { RedirectComponent } from './redirect/redirect.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';

const routes: Routes = [
  { path: "login", component: LogInComponent},
  { path: "inscription", component: InscriptionComponent},
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "recherche", component: RechercheLogementComponent },
  { path: "rechercheLocataires", component: RechercheLocataireComponent },
  { path: "proprietaire/:id", component: ProprietaireComponent},
  { path: "**", component: RedirectComponent},
  { path: "ajoutLogement", component: AjoutLogementComponent},
  { path: "descriptionLogement", component: DescriptionLogementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
