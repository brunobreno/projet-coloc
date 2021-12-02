import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';

const routes: Routes = [
  {path: "proprietaire/:id", component: ProprietaireComponent},
  {path: "profilLocataire", component: ProfilLocataireComponent},
  {path: "", redirectTo: "profilLocataire", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
