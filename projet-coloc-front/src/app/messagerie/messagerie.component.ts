import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { Message, UtilisateurDTO, MessageDTO } from '../model';
import { MessagerieService } from './messagerie.service';

@Component({
  selector: 'app-messagerie',
  templateUrl: './messagerie.component.html',
  styleUrls: ['./messagerie.component.scss']
})
export class MessagerieComponent implements OnInit {

  utilisateurConnecte: UtilisateurDTO;
  conversations: Array<Message> = new Array<Message>();
  conversation: Array<Message> = new Array<Message>();
  relationsId: Array<number> = new Array<number>(); 
  relations: Array<UtilisateurDTO> = new Array<UtilisateurDTO>();
  messageForm: MessageDTO = new MessageDTO();

  constructor(private appConfig: AppConfigService, private messagerieService: MessagerieService) {
    //A modifier quand l'utilisateur se connecte
    //this.utilisateurConnecte = this.appConfig.utilisateurConnecte;
    messagerieService.findUtilisateurById(6).subscribe(resp => {
      this.utilisateurConnecte = resp;
      this.loadConversations();
      this.messageForm.emetteurId = this.utilisateurConnecte.id;
    }, err => console.log(err))    
   }

  ngOnInit(): void {
  }

  findRelationsId(){
    this.conversations.forEach(m => {
      if(m.emetteur.id != this.utilisateurConnecte.id && !this.relationsId.includes(m.emetteur.id)){
        this.relationsId.push(m.emetteur.id);
      }
      if(m.destinataire.id != this.utilisateurConnecte.id && !this.relationsId.includes(m.destinataire.id)){
        this.relationsId.push(m.destinataire.id);
      }
    })
    this.findRelations();
  }

  //a appeler quand click sur conversation
  findConversation(id: number){
    this.conversation = new Array<Message>();
    this.conversations.forEach(m => {
      if((m.emetteur.id == id || m.destinataire.id == id) && !this.conversation.includes(m)){
        this.conversation.push(m);
      }
    });
    this.setMessageFormDestinataire(id);
  }

  setMessageFormDestinataire(id:number){
    this.messagerieService.findUtilisateurById(id).subscribe(resp => {
      this.messageForm.destinataireId = resp.id;
    }, err => console.log(err))
  }

  envoyerMessage(){
    if(this.messageForm.contenu != null && this.messageForm.contenu != ""){
      console.log(this.messageForm);
      this.messagerieService.sendMessage(this.messageForm).subscribe(resp => {
        this.messageForm.contenu = "";
        this.loadConversations();
        this.conversation = new Array<Message>();
      }, err => {
        console.log(err);
        this.messageForm.contenu = "";
      })
    }
  }

  findRelations(){
    for(let id of this.relationsId){
      this.messagerieService.findUtilisateurById(id).subscribe(resp => {
        this.relations.push(resp);
      }, err => console.log(err))
    }
  }

  loadConversations(){
    this.messagerieService.findMessagesById(this.utilisateurConnecte.id).subscribe(resp => {
      this.conversations = resp;
      this.relations = new Array<UtilisateurDTO>();
      this.relationsId = new Array<number>();
      this.findRelationsId();
    });
  }
}
