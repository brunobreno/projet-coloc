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
export class Utilisateur {
    id: number;
    version: number;
    nom: string;
    prenom: string;
    civ: string;
    email: string;
    tel: string;
    password: string;

    constructor(id?: number,version?: number, nom?: string, prenom?: string,civ?: string, email?: string,tel?: string,password?: string) {
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

export class Locataire extends Utilisateur {

    recherche: boolean;
    description: string;
    situation: string;
    dossier: Dossier;
    dateDeNaissance: string;
    // chambre: Chambre;

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