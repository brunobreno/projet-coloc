export class ConnexionDTO {
    username: string;
    password: string;

    constructor(username?: string, password?: string) {
        this.username = username;
        this.password = password;
    }
}

export class Utilisateur {
    id: number;
    username: string;
    nom: string;
    prenom: string;
    civ: string;
    email: string;
    tel: string;
    password: string;
    stringRoles: Array<string> = new Array<string>();

    constructor(id?: number, username?: string, nom?: string, prenom?: string, civ?: string, email?: string, tel?: string, password?: string) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.civ = civ;
        this.email = email;
        this.tel = tel;
        this.password = password;
    }
}