import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';

const routes: Routes = [
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "", redirectTo: "profilLocataire", pathMatch: "full" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
