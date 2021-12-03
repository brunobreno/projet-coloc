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
    dossier : Dossier;

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

export class Dossier {
    revenu : number;
    revenuGarant: number;
    situationGarant: string;

    constructor(revenu?: number, revenuGarant?: number, situationGarant?: string){
        this.revenu = revenu;
        this.revenuGarant = revenuGarant;
        this.situationGarant = situationGarant;
    }
}
import { PathLocationStrategy } from "@angular/common";

export class Utilisateur {
    id: number;
    version: number;
    nom: string;
    prenom: string;
    civ: string;
    email: string;
    tel: string;
    password: string;

    constructor(id?: number, version?: number, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.prenom = prenom;
        this.civ = civ;
        this.email = email;
        this.tel = tel;
        this.password = password;
    }
}

export class Proprietaire extends Utilisateur {
    logements: Array<Logement> = new Array <Logement>();

    constructor(id?: number, version?: number, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
        super(id, version, nom, prenom, civ, email, tel, password);
    }
}

export class Logement {
    id: number;
    version: number;
    description: string;
    surface: number;
    nChambre: number;
    nChambreOccup: number;
    nSdb: number;
    loyer: number;
    charges: number;
    caution: number;

    constructor(id?: number, version?: number, description?: string, surface?: number, nChambre?: number, nChambreOccup?: number, nSdb?: number, loyer?: number, charges?: number, caution?: number) {
        this.id = id;
        this.version = version;
        this.description = description;
        this.surface = surface;
        this.nChambre = nChambre;
        this.nChambreOccup = nChambreOccup;
        this.nSdb = nSdb;
        this.loyer = loyer;
        this.charges = charges;
        this.caution = caution;
    }
}

export class Locataire extends Utilisateur {
export class Candidature{
    id: number;
    version: number;
    locataires: Array<Locataire> = new Array <Locataire>();
    chambre: Chambre;
    validation: boolean;
    enAttente: boolean;

    recherche: boolean;
    description: string;
    situation: string;
    dossier: Dossier;
    dateDeNaissance: string;
    // chambre: Chambre;
  constructor(
    id?: number, 
    version?: number, 
    locataires?: Array<Locataire> , 
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

    constructor(id?: number,version?: number, nom?: string, prenom?: string,civ?: string, email?: string,tel?: string,password?: string,recherche?: boolean, description?: string,situation?: string, dateDeNaissance?: string, dossier?: Dossier, /*chambre?: Chambre */) {
        super(id,version,nom,prenom,civ,email,tel,password);
        this.recherche = recherche;
        this.description = description;
        this.situation = situation;
        this.dateDeNaissance = dateDeNaissance;
        this.dossier = dossier;
        // this.chambre = chambre;
    }
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
    dossier : Dossier;
export class Chambre {
    id: number;
    version: number;
    logement: Logement;
    locataire: Locataire;
    surface: number;
    commodites: Array<Commodite> = new Array <Commodite>();
    candidatures: Array<Candidature> = new Array <Candidature>();

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
  constructor(
    id?: number, 
    version?: number, 
    logement?: Logement, 
    locataire?: Locataire, 
    surface?: number, 
    commodites?: Array<Commodite> , 
    candidatures?: Array<Candidature> 
) {
    this.id = id
    this.version = version
    this.logement = logement
    this.locataire = locataire
    this.surface = surface
    this.commodites = commodites
    this.candidatures = candidatures
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
export class Commodite{
    id: number;
    version: number;
    libelle: string;
    chemin: string;
    logements: Array<Logement> = new Array <Logement>();
    chambres: Array<Chambre> = new Array <Chambre>();

  constructor(
    id?: number, 
    version?: number, 
    libelle?: string, 
    chemin?: string, 
    logements?: Array<Logement> , 
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

export class Localisation{
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
    this.departement = departement
    this.ville = ville
    this.codePostal = codePostal
    this.voie = voie
    this.num = num
  }

}


export class Locataire extends Utilisateur {

    recherche: boolean;
    description: string;
    situation: string;
    dossier: Dossier;
    chambre: Chambre;
    candidatures: Array<Candidature> = new Array <Candidature>();

  constructor(
    id?: number, 
    version?: number, 
    nom?: string, 
    prenom?: string, 
    civ?: string, 
    email?: string, 
    tel?: string, 
    password?: string,
    recherche?: boolean, 
    description?: string, 
    situation?: string, 
    dossier?: Dossier, 
    chambre?: Chambre, 
    candidatures?: Array<Candidature> 
) {
    super(id,version, nom, prenom, civ,email,tel,password)
    this.recherche = recherche
    this.description = description
    this.situation = situation
    this.dossier = dossier
    this.chambre = chambre
    this.candidatures = candidatures
  }

}

export class Logement {
    id: number;
    version: number;
    description: string;
    surface: number;
    nChambre: number;
    nChambreOccup: number;
    nSdb: number;
    loyer: number;
    charges: number;
    caution: number;
    dateDispo : string;
    typeLogement: string;
    photos: Array<Photo> = new Array <Photo>();
    //notations: Array<Notation> = new Array <Notation>();
    proprietaire: Proprietaire;
    localisation : Localisation;
    chambres: Array<Chambre> = new Array<Chambre>();
    commodites: Array<Commodite> = new Array<Commodite>();
    regles: Array<Regle> = new Array<Regle>();


  constructor(
    id?: number, 
    version?: number, 
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
    photos?: Array<Photo> , 
    //notations?: Array<Notation> , 
    proprietaire?: Proprietaire, 
    localisation?: Localisation, 
    chambres?: Array<Chambre> , 
    commodites?: Array<Commodite> , 
    regles?: Array<Regle> 
) {
    this.id = id
    this.version = version
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
  }
	
}

export class Message {
    id: number;
    version: number;
    emetteur: Utilisateur;
    destinataire: Utilisateur;
    contenu: string;
    date: string;

  constructor(
    id?: number, 
    version?: number, 
    emetteur?: Utilisateur, 
    destinataire?: Utilisateur, 
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
    logements: Array<Logement> = new Array <Logement>();

    constructor(id?: number, version?: number, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
        super(id, version, nom, prenom, civ, email, tel, password);
    }
}

export class Regle{
    id: number;
    version: number;
    logements: Array<Logement> = new Array <Logement>();

  constructor(
    id?: number, 
    version?: number, 
    logements?: Array<Logement> 
) {
    this.id = id
    this.version = version
    this.logements = logements
  }
    
}










       