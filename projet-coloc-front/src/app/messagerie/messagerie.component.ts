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
  destinataireId: number;

  constructor(private appConfig: AppConfigService, private messagerieService: MessagerieService) {
    //A modifier quand l'utilisateur se connecte
    //this.utilisateurConnecte = this.appConfig.utilisateurConnecte;
    messagerieService.findUtilisateurById(6).subscribe(resp => {
      this.utilisateurConnecte = resp;
      this.messageForm.emetteurId = this.utilisateurConnecte.id;
      this.loadConversations();
    }, err => console.log(err))    
   }

  ngOnInit(): void {
  }

  loadConversations(){
    // Charge toutes les conversions de l'utilisateur connecté
    this.messagerieService.findMessagesById(this.utilisateurConnecte.id).subscribe(resp => {
      this.conversations = resp;
      this.relations = new Array<UtilisateurDTO>();
      this.relationsId = new Array<number>();
      this.findRelationsId();
    });
  }

  findRelationsId(){
    // Trouve tous les id des correspondants de l'utilisateur connecté
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

  findRelations(){
    // Trouve les utilisateur en fonction des id récupérés
    for(let id of this.relationsId){
      this.messagerieService.findUtilisateurById(id).subscribe(resp => {
        this.relations.push(resp);
      }, err => console.log(err))
    }
  }

  findConversation(id: number){
    this.destinataireId = id;
    this.loadConversation();
    this.setMessageFormDestinataire(id);
  }

  setMessageFormDestinataire(id:number){
    this.messagerieService.findUtilisateurById(id).subscribe(resp => {
      this.messageForm.destinataireId = resp.id;
    }, err => console.log(err))
  }

  loadConversation(){
    // Filtre l'ensemble des messages pour conserver que les messages de l'interlocuteur choisi
    this.conversation = new Array<Message>();
    this.conversations.forEach(m => {
      if((m.emetteur.id == this.destinataireId || m.destinataire.id == this.destinataireId) && !this.conversation.includes(m)){
        this.conversation.push(m);
      }
    });
  }

  envoyerMessage(){
    if(this.messageForm.contenu != null && this.messageForm.contenu != ""){
      this.messagerieService.sendMessage(this.messageForm).subscribe(resp => {
        this.messageForm.contenu = "";
        this.conversations.push(resp)
        this.conversation.push(resp);
      }, err => {
        console.log(err);
        this.messageForm.contenu = "";
      })
    }
  }

  afficherMessages(): Array<Message> {
    return this.conversation;
  }

  findLastMessages(): Message {
    return this.conversation[this.conversation.length-1];
  }
}
