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

export class Locataire extends Utilisateur {

    recherche: boolean;
    description: string;
    situation: string;
    // dossier: Dossier;
    // chambre: Chambre;

    constructor(id?: number,version?: number, nom?: string, prenom?: string,civ?: string, email?: string,tel?: string,password?: string,recherche?: boolean, description?: string,situation?: string, /* dossier?: Dossier, chambre?: Chambre */) {
        super(id,version,nom,prenom,civ,email,tel,password);
        this.recherche = recherche;
        this.description = description;
        this.situation = situation;
        // this.dossier = dossier;
        // this.chambre = chambre;
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
