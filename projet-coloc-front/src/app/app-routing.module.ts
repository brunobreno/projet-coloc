import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfilLocataireComponent } from './profil-locataire/profil-locataire.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LogInComponent } from './log-in/log-in.component';

const routes: Routes = [
  {path:"login", component: LogInComponent},
  {path:"inscription", component: InscriptionComponent},
];
  { path: "profilLocataire", component: ProfilLocataireComponent},
  { path: "", redirectTo: "profilLocataire", pathMatch: "full" }

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
