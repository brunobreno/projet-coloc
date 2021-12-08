import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppConfigService } from '../app-config.service';
import { MessageDTO, UtilisateurDTO } from '../model';
import { MessagerieNouveauContactService } from './messagerie-nouveau-contact.service';

@Component({
  selector: 'app-messagerie-nouveau-contact',
  templateUrl: './messagerie-nouveau-contact.component.html',
  styleUrls: ['./messagerie-nouveau-contact.component.scss']
})
export class MessagerieNouveauContactComponent implements OnInit {

  utilisateurConnecte: UtilisateurDTO;
  destinataire : UtilisateurDTO;
  messageForm: MessageDTO = new MessageDTO();
  destinataireId: number;
  messageEnvoye:boolean = false;

  constructor(private route: ActivatedRoute, private messagerieNouveauContactService : MessagerieNouveauContactService, private appConfig: AppConfigService, private router: Router) {
    //A modifier suite à la connexion de l'utilisateur
    this.utilisateurConnecte = this.appConfig.utilisateurConnecte;
    this.route.params.subscribe(params => {
      this.destinataireId = params['id'];
      messagerieNouveauContactService.findUtilisateurById(this.destinataireId).subscribe(resp => {
        this.destinataire = resp;
      }, err => console.log(err));
      messagerieNouveauContactService.findUtilisateurById(this.utilisateurConnecte.id).subscribe(resp => {
      }, err => console.log(err));
    });
   }

  ngOnInit(): void {
  }

  envoyerMessage(){
    if(this.messageForm.contenu != null && this.messageForm.contenu != ""){
      this.messageForm.emetteurId = this.utilisateurConnecte.id;
      this.messageForm.destinataireId = this.destinataireId;
      this.messagerieNouveauContactService.sendMessage(this.messageForm).subscribe(resp => {
        this.messageEnvoye = true;
        setTimeout(() =>{
          this.messageForm.contenu = "";
          this.messageEnvoye = false;
          this.router.navigate(['./messagerie']);
        }, 3000);
      }, err => {
        console.log(err);
        this.messageForm.contenu = "";
      })
    }
  }
}
