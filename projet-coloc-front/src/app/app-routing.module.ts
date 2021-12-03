import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjoutLogementComponent } from './ajout-logement/ajout-logement.component';
import { DescriptionLogementComponent } from './description-logement/description-logement.component';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';

const routes: Routes = [
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "ajoutLogement", component: AjoutLogementComponent },
  { path: "descriptionLogement", component: DescriptionLogementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
