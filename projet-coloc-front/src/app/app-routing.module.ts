import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';

const routes: Routes = [
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "", redirectTo: "profilLocataire", pathMatch: "full" },
  { path: "recherche", component: RechercheLogementComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
