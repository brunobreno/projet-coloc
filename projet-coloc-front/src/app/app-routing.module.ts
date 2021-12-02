import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProprietaireComponent } from './proprietaire/proprietaire.component';

const routes: Routes = [
  {path: "proprietaire/:id", component: ProprietaireComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
