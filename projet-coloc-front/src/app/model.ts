import { PathLocationStrategy } from "@angular/common";

export class Utilisateur {
  id: number;
  version: number;
  username: string;
  nom: string;
  prenom: string;
  civ: string;
  email: string;
  tel: string;
  password: string;

  constructor(id?: number, version?: number, username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
    this.id = id;
    this.version = version;
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.civ = civ;
    this.email = email;
    this.tel = tel;
    this.password = password;
  }
}

export class Candidature {
  id: number;
  version: number;
  locataires: Array<Locataire> = new Array<Locataire>();
  chambre: Chambre;
  validation: boolean;
  enAttente: boolean;

  constructor(
    id?: number,
    version?: number,
    locataires?: Array<Locataire>,
    chambre?: Chambre,
    validation?: boolean,
    enAttente?: boolean
  ) {
    this.id = id
    this.version = version
    this.locataires = locataires
    this.chambre = chambre
    this.validation = validation
    this.enAttente = enAttente
  }

}

export class Chambre {
  id: number;
  version: number;
  logement: Logement;
  locataire: Locataire;
  surface: number;
  description: String;
  commodites: Array<Commodite> = new Array<Commodite>();
  candidatures: Array<Candidature> = new Array<Candidature>();
  photos:  Array<Photo> = new Array<Photo>();

  constructor(
    id?: number,
    version?: number,
    logement?: Logement,
    locataire?: Locataire,
    surface?: number,
    description?: string,
    commodites?: Array<Commodite>,
    candidatures?: Array<Candidature>,
    photos?:Array<Photo>
  ) {
    this.id = id
    this.version = version
    this.logement = logement
    this.locataire = locataire
    this.surface = surface
    this.description = description
    this.commodites = commodites
    this.candidatures = candidatures
    this.photos = photos;
  }

}

export class Commodite {
  id: number;
  version: number;
  libelle: string;
  chemin: string;
  logements: Array<Logement> = new Array<Logement>();
  chambres: Array<Chambre> = new Array<Chambre>();

  constructor(
    id?: number,
    version?: number,
    libelle?: string,
    chemin?: string,
    logements?: Array<Logement>,
    chambres?: Array<Chambre>
  ) {
    this.id = id
    this.version = version
    this.libelle = libelle
    this.chemin = chemin
    this.logements = logements
    this.chambres = chambres
  }
}

export class Dossier {
  revenuGarant: number;
  revenu: number;
  situationGarant: string;

  constructor(revenu?: number, revenuGarant?: number, situationGarant?: string) {
    this.revenu = revenu;
    this.revenuGarant = revenuGarant;
    this.situationGarant = situationGarant;
  }
}

export class Localisation {
  departement: string;
  ville: string;
  codePostal: string;
  voie: string;
  num: number;

  constructor(
    departement?: string,
    ville?: string,
    codePostal?: string,
    voie?: string,
    num?: number
  ) {
    this.departement = departement;
    this.ville = ville;
    this.codePostal = codePostal;
    this.voie = voie;
    this.num = num;
  }

}

export class Hobby {
  id: number;
  version: number;
  libelle: string;
  chemin: string;
  locataires: Array<Locataire> = new Array<Locataire>();

  constructor(
    id?: number,
    version?: number,
    libelle?: string,
    chemin?: string,
    locataires?: Array<Locataire>
  ) {
    this.id = id
    this.version = version
    this.libelle = libelle
    this.chemin = chemin
    this.locataires = locataires
  }


}


export class Locataire extends Utilisateur {

  recherche: boolean;
  description: string;
  situation: string;
  dateDeNaissance: string;
  dossier: Dossier;
  chambre: Chambre;
  candidatures: Array<Candidature> = new Array<Candidature>();
  photos: Array<Photo> = new Array<Photo>();
  hobbies: Array<Hobby> = new Array<Hobby>();

  constructor(
    id?: number,
    version?:number,
    nom?: string,
    prenom?: string,
    civ?: string,
    email?: string,
    tel?: string,
    password?: string,
    recherche?: boolean,
    description?: string,
    situation?: string,
    dateDeNaissance?: string,
    dossier?: Dossier,
    chambre?: Chambre,
    candidatures?: Array<Candidature>,
    photos?: Array<Photo>,
    hobbies?: Array<Hobby>
  ) {
    super(id, version, nom, prenom, civ, email, tel, password)
    this.recherche = recherche
    this.description = description
    this.situation = situation
    this.dateDeNaissance = dateDeNaissance
    this.dossier = dossier
    this.chambre = chambre
    this.candidatures = candidatures
    this.photos = photos;
    this.hobbies = hobbies;
  }

}

export class Logement {
  id: number;
  version: number;
  titre: string;
  description: string;
  surface: number;
  nChambre: number;
  nChambreOccup: number;
  nSdb: number;
  loyer: number;
  charges: number;
  caution: number;
  dateDispo: string;
  typeLogement: string;
  photos: Array<Photo> = new Array<Photo>();
  //notations: Array<Notation> = new Array <Notation>();
  proprietaire: Proprietaire;
  localisation: Localisation;
  chambres: Array<Chambre> = new Array<Chambre>();
  commodites: Array<Commodite> = new Array<Commodite>();
  regles: Array<Regle> = new Array<Regle>();
  meuble: boolean;


  constructor(
    id?: number,
    version?: number,
    titre?: string,
    description?: string,
    surface?: number,
    nChambre?: number,
    nChambreOccup?: number,
    nSdb?: number,
    loyer?: number,
    charges?: number,
    caution?: number,
    dateDispo?: string,
    typeLogement?: string,
    photos?: Array<Photo>,
    //notations?: Array<Notation> , 
    proprietaire?: Proprietaire,
    localisation?: Localisation,
    chambres?: Array<Chambre>,
    commodites?: Array<Commodite>,
    regles?: Array<Regle>,
    meuble?: boolean
  ) {
    this.id = id
    this.version = version
    this.titre = titre
    this.description = description
    this.surface = surface
    this.nChambre = nChambre
    this.nChambreOccup = nChambreOccup
    this.nSdb = nSdb
    this.loyer = loyer
    this.charges = charges
    this.caution = caution
    this.dateDispo = dateDispo
    this.typeLogement = typeLogement
    this.photos = photos
    //this.notations = notations
    this.proprietaire = proprietaire
    this.localisation = localisation
    this.chambres = chambres
    this.commodites = commodites
    this.regles = regles
    this.meuble=meuble
  }

}

export class Message {
  id: number;
  version: number;
  emetteur: UtilisateurDTO;
  destinataire: UtilisateurDTO;
  contenu: string;
  date: string;

  constructor(
    id?: number,
    version?: number,
    emetteur?: UtilisateurDTO,
    destinataire?: UtilisateurDTO,
    contenu?: string,
    date?: string
  ) {
    this.id = id
    this.version = version
    this.emetteur = emetteur
    this.destinataire = destinataire
    this.contenu = contenu
    this.date = date
  }

}

export class Photo {
  id: number;
  version: number;
  libelle: string;
  chemin: string;
  ordre: number;
  logement: Logement;

  constructor(
    id?: number,
    version?: number,
    libelle?: string,
    chemin?: string,
    ordre?: number,
    logement?: Logement
  ) {
    this.id = id
    this.version = version
    this.libelle = libelle
    this.chemin = chemin
    this.ordre = ordre
    this.logement = logement
  }

}

export class Proprietaire extends Utilisateur {
  logements: Array<Logement> = new Array<Logement>();

  constructor(id?: number, version?: number, username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
    super(id, version, username, nom, prenom, civ, email, tel, password);
  }
}

export class Regle {
  id: number;
  version: number;
  libelle: string;
  chemin: string;
  logements: Array<Logement> = new Array<Logement>();

  constructor(
    id?: number,
    version?: number,
    libelle?: string,
    chemin?: string,
    logements?: Array<Logement>
  ) {
    this.id = id
    this.version = version
    this.libelle = libelle
    this.chemin = chemin
    this.logements = logements
  }
}
export class ConnexionDTO {
  username: string;
  password: string;

  constructor(username?: string, password?: string) {
    this.username = username;
    this.password = password;
  }
}

export class UtilisateurDTO {
  id: number;
  username: string;
  nom: string;
  prenom: string;
  civ: string;
  email: string;
  tel: string;
  password: string;
  stringRoles: Array<string> = new Array<string>();
  typeDeCompte: string;
  recherche: boolean;
  description: string;
  situation: string;
  dateDeNaissance: string;
  dossier: Dossier;

  constructor(id?: number, username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string, typeDeCompte?: string, recherche?: boolean, description?: string, situation?: string, dateDeNaissance?: string, dossier?: Dossier) {
    this.id = id;
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.civ = civ;
    this.email = email;
    this.tel = tel;
    this.password = password;
    this.typeDeCompte = typeDeCompte;
    this.recherche = recherche;
    this.description = description;
    this.situation = situation;
    this.dateDeNaissance = dateDeNaissance;
    this.dossier = dossier;
  }
}

export class LocataireDTOInscription {
  username: string;
  nom: string;
  prenom: string;
  civ: string;
  email: string;
  tel: string;
  password: string;
  recherche: boolean;
  description: string;
  situation: string;
  dateDeNaissance: string;
  dossier: Dossier;

  constructor(username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string, recherche?: boolean, description?: string, situation?: string, dateDeNaissance?: string, dossier?: Dossier) {
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.civ = civ;
    this.email = email;
    this.tel = tel;
    this.password = password;
    this.recherche = recherche;
    this.description = description;
    this.situation = situation;
    this.dateDeNaissance = dateDeNaissance;
    this.dossier = dossier;
  }
}

export class ProprietaireDTOInscription {
  username: string;
  nom: string;
  prenom: string;
  civ: string;
  email: string;
  tel: string;
  password: string;

  constructor(username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
    this.username = username;
    this.nom = nom;
    this.prenom = prenom;
    this.civ = civ;
    this.email = email;
    this.tel = tel;
    this.password = password;
  }
}

export class MessageDTO {
  emetteurId: number;
  destinataireId: number;
  contenu: string;

  constructor(
    emetteurId?: number,
    destinataireId?: number,
    contenu?: string,
  ) {
    this.emetteurId = emetteurId
    this.destinataireId = destinataireId
    this.contenu = contenu
  }
}