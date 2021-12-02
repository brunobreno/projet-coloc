import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RechercheLogementComponent } from './recherche-logement/recherche-logement.component';

const routes: Routes = [
  { path: "recherche", component: RechercheLogementComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
