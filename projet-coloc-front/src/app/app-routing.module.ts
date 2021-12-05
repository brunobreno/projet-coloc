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
import { HomePageComponent } from './home-page/home-page.component';
import { MessagerieComponent } from './messagerie/messagerie.component';

const routes: Routes = [
  { path: "", component: HomePageComponent},
  { path: "home", component: HomePageComponent},
  { path: "login", component: LogInComponent},
  { path: "inscription", component: InscriptionComponent},
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "recherche", component: RechercheLogementComponent },
  { path: "recherche-locataires", component: RechercheLocataireComponent },
  { path: "proprietaire/:id", component: ProprietaireComponent},
  { path: "ajoutLogement", component: AjoutLogementComponent},
  { path: "descriptionLogement", component: DescriptionLogementComponent},
  { path: "messagerie", component: MessagerieComponent},
  { path: "**", component: RedirectComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
