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
import { MessagerieNouveauContactComponent } from './messagerie-nouveau-contact/messagerie-nouveau-contact.component';
import { LogementProprietaireComponent } from './logement-proprietaire/logement-proprietaire.component';
import { DeconnexionComponent } from './deconnexion/deconnexion.component';

const routes: Routes = [
  { path: "", redirectTo: '/home', pathMatch: 'full'},
  { path: "home", component: HomePageComponent},
  { path: "login", component: LogInComponent},
  { path: "inscription", component: InscriptionComponent},
  { path: "recherche-locataires", component: RechercheLocataireComponent },
  { path: "recherche-logement/undefined", component: RechercheLogementComponent },
  { path: "recherche-logement/:ville", component: RechercheLogementComponent },
  { path: "locataire/:id", component: ProfilLocataireComponent},
  { path: "proprietaire/:id", component: ProprietaireComponent},
  { path: "ajout-logement", component: AjoutLogementComponent},
  { path: "description-logement/:id", component: DescriptionLogementComponent},
  { path: "messagerie", component: MessagerieComponent},
  { path: "messagerie-nouveau/:id", component: MessagerieNouveauContactComponent},
  { path: "logements-proprietaire/:id", component: LogementProprietaireComponent},
  { path: "deconnexion", component: DeconnexionComponent},
  { path: "**", component: RedirectComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
