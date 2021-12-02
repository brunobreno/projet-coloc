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
    // chambre: Chambre;

    constructor(id?: number,version?: number, nom?: string, prenom?: string,civ?: string, email?: string,tel?: string,password?: string,recherche?: boolean, description?: string,situation?: string, dossier?: Dossier, /*chambre?: Chambre */) {
        super(id,version,nom,prenom,civ,email,tel,password);
        this.recherche = recherche;
        this.description = description;
        this.situation = situation;
        this.dossier = dossier;
        // this.chambre = chambre;
    }


}

export class Dossier {
    revenu: number;
    revenuGarant: number;
    situationGarant: string;

    constructor(revenu?: number, revenuGarant?: number, situationGarant?: string) {
        this.revenu = revenu;
        this.revenuGarant = revenuGarant;
        this.situationGarant = situationGarant;
    }
}

