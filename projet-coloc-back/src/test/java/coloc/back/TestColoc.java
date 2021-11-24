import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestColoc {
	
	//----------------------------------------------------------------------
	
	/*
	 * Methodes des menus
	 */
	
	public static void menuPrincipal() {
		System.out.println("1 - Se connecter");
		System.out.println("2 - Creer un compte");
		System.out.println("3 - STOP");
	
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : creerCompte();break;
		case 3 : System.exit(0);
		}
		menuPrincipal();
	}
	
	public static void menuLocataire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Voir les annonces");
		System.out.println("3 - Lire mes messages");
		System.out.println("4 - Envoyer un message");
		System.out.println("5 - Noter un appartement");
		System.out.println("6 - Se deconnecter");
		System.out.println("7 - STOP");
		
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : voirAnnonce();break;
		case 3 : afficherListeMessageRecus();break;
		case 4 : envoyerMessage();break;
		case 5 : noterAppart();break;
		case 6 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);menuPrincipal();break;
		case 7 : System.exit(0);
		}
	}
	
	public static void menuProprietaire() {
		System.out.println("1 - Voir/Modifier mon profil");
		System.out.println("2 - Ajouter un logement");
		System.out.println("3 - Voir/Modifier un logement");
		System.out.println("4 - Voir les dossiers de candidature");
		System.out.println("5 - Modifier les disponibilites d'un logement");
		System.out.println("6 - Lire mes messages");
		System.out.println("7 - Ecrire un message");
		System.out.println("8 - Se deconnecter");
		System.out.println("9 - Stop");
		
		int choix = Context.getInstance().saisieInt("Choisir un menu :");
		switch(choix)
		{
		case 1 : modifierProfil();break;
		case 2 : ajoutAppart();break;
		case 3 : modifAppart();break;
		case 4 : voirDossier();break;
		case 5 : rendreDispo();break;
		case 6 : afficherListeMessageRecus();break;
		case 7 : envoyerMessage();break;
		case 8 : System.out.println("Deconnexion...");Context.getInstance().setUtilisateurConnecte(null);menuPrincipal();break;
		case 9 : System.exit(0);
		}
	}

	public static void retourMenu() {
		// Test OK
		if(Context.getInstance().getUtilisateurConnecte() instanceof Locataire) {
			menuLocataire();
		} else {
			menuProprietaire();
		}
	}
	
	public static void connexion() {
		// Test OK
		// Permet de se connecter a un compte utilisateur et mettre l'utlisiteur dans le contexte
		String email = Context.getInstance().saisieString("Saisir votre email : ");
		String password = Context.getInstance().saisieString("Saisir votre password : ");
		
		Utilisateur connexion = Context.getInstance().getDaoUtilisateur().connect(email,password);
		if(connexion == null) {
			System.out.println("Utilisateur non reconnu");
			connexion();
		}
		Context.getInstance().setUtilisateurConnecte(connexion);
		//
		if(connexion instanceof Locataire) {menuLocataire();}
		else if(connexion instanceof Proprietaire) {menuProprietaire();}
		else {System.out.println("Identifiants invalides");connexion();}
	}
	
	/*
	 * Methodes comptes
	 */
	
	public static void creerCompte() {
		boolean nouveauMail = false;
		System.out.println("Creation de compte :");
		String nom = Context.getInstance().saisieString("Entrez votre nom : ");
		String prenom = Context.getInstance().saisieString("Entrez votre prenom : ");
		System.out.println("Voici les civilités disponibles : ");
		for(Civilite civ : Civilite.values()) {System.out.println(civ);}
		Civilite civ = Civilite.valueOf(Context.getInstance().saisieString("Choisissez votre civilite : "));
		String email = "";
		while(!nouveauMail) {
			email = Context.getInstance().saisieString("Entrez votre email : ");
			Utilisateur utilisateurExistant = Context.getInstance().getDaoUtilisateur().findByEmail(email);
			if(utilisateurExistant != null) {
				System.out.println("Un compte est deja existant pour cet email.");
			} else {
				nouveauMail = true;
			}
		}
		String tel = Context.getInstance().saisieString("Entrez votre numero de telephone : ");
		String password = Context.getInstance().saisieString("Entrez votre mot de passe : ");
		int choixTypeCompte = Context.getInstance().saisieInt("Etes vous 1-Proprietaire ou 2-Locataire :");
		if(choixTypeCompte == 1) {
			Proprietaire proprioACreer = new Proprietaire(nom, prenom, civ, email, tel, password, null);
			Context.getInstance().getDaoProprio().save(proprioACreer);
		}else{
			String choixRecherche = Context.getInstance().saisieString("Etes vous en recherche de colocation (O/N) : ");
			boolean recherche = false;
			if(choixRecherche.toLowerCase().equals("o")) {recherche = true;}
			System.out.println("Voici les situtations disponibles : ");
			for(Situation sit : Situation.values()) {System.out.println(sit);}
			Situation situation = Situation.valueOf(Context.getInstance().saisieString("Choisissez votre situation : "));
			String description = Context.getInstance().saisieString("Saisissez votre description : ");
			Locataire locataireACreer = new Locataire(nom, prenom, civ, email, tel, password, recherche, description, situation, null, null);
			Context.getInstance().getDaoLocataire().save(locataireACreer);
		}
		System.out.println("Profil cree");
		menuPrincipal();
	}
	
	public static void modifierProfil() {
		
		Utilisateur connected = Context.getInstance().getUtilisateurConnecte();
		System.out.println("1 - Le nom");
		System.out.println("2 - Le prenom");
		System.out.println("3 - La civilite");
		System.out.println("4 - L'adresse mail");
		System.out.println("5 - Le numero de telephone");
		System.out.println("6 - Rien, seulement voir le profil");
	
		int choix = Context.getInstance().saisieInt("Que souhaitez-vous modifier ?");
		
		String modif = null;
		
		if(choix==6) {}
		else{
			modif = Context.getInstance().saisieString("Saisir la modif");
		}
		
		switch(choix) 
		{
		case 1 : connected.setNom(modif);break;
		case 2 : connected.setPrenom(modif);break;
		case 3 : connected.setCiv(Civilite.valueOf(modif));break;
		case 4 : connected.setEmail(modif);break;
		case 5 : connected.setTel(modif);break;
		case 6 : break;
		
		}
		
		Context.getInstance().getDaoUtilisateur().save(connected);
		System.out.println(connected);
		
		retourMenu();
	}
	
	/*
	 * Methodes messages
	 */
	
	public static void afficherListeMessageRecus() {
		// Test OK
		// Affiche la liste des messages reçus
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdDestinataireWithUtilisateur(Context.getInstance().getUtilisateurConnecte().getId());
		if(messages.size() != 0) {
			for(Message m : messages) {
				System.out.println("Message numero " + m.getId() + " de " + m.getEmetteur().getNom() + " " + m.getEmetteur().getPrenom());
			}
			String choix = Context.getInstance().saisieString("Voulez vous lire un message : (O/N)");
			if(choix.toUpperCase().equals("O")) {
				int idMessage = Context.getInstance().saisieInt("Entrez le numero du message que vous souhaitez lire : ");
				afficherMessage(idMessage);
			} else {
				retourMenu();
			}
		} else {
			System.out.println("Pas de message reçu");
			retourMenu();
		}
	}
	
	public static void afficherListeMessageEnvoyes() {
		// Test OK
		// Affiche la liste des messages envoyes
		List<Message> messages = Context.getInstance().getDaoMessage().findAllByIdEmetteurWithUtilisateur(Context.getInstance().getUtilisateurConnecte().getId());
		for(Message m : messages) {
			System.out.println("Message numero " + m.getId() + " a " + m.getDestinataire().getNom() + " " + m.getDestinataire().getPrenom());
		}
		retourMenu();
	}
	
	public static void afficherMessage(int idMessage) {
		// Test OK
		// Affiche un message par son id dans la BDD
		Message message = Context.getInstance().getDaoMessage().findByIdWithUtilisateur(idMessage);
		System.out.println("Message n°" + message.getId() +" de " + message.getEmetteur().getNom() + " " + message.getEmetteur().getPrenom());
		System.out.println(message.getContenu());
		String choix = Context.getInstance().saisieString("Voulez vous supprimer ce message : (O/N)");
		if(choix.toUpperCase().equals("O")) {
			supprimerMessage(message.getId());
		}
		retourMenu();
	}
	
	public static void supprimerMessage(int idMessage) {
		// Test OK
		// Supprime un message par son id dans la BDD
		Message message = Context.getInstance().getDaoMessage().findById(idMessage);
		Context.getInstance().getDaoMessage().delete(message);
		System.out.println("Message supprime");
		retourMenu();
	}
	
	public static void envoyerMessage() {
		// Test OK
		// Envoie un nouveau message
		String mailDestinataire = Context.getInstance().saisieString("Entrez l'email du destinataire : ");
		Utilisateur destinataire = Context.getInstance().getDaoUtilisateur().findByEmail(mailDestinataire);
		if(destinataire == null) {
			System.out.println("L'adresse mail saisie ne correspond a aucun utilisateur.");
			envoyerMessage();
		}
		String contenu = Context.getInstance().saisieString("Saissisez votre message : ");
		Message newMessage = new Message(Context.getInstance().getUtilisateurConnecte(), destinataire, contenu);
		newMessage = Context.getInstance().getDaoMessage().save(newMessage);
		System.out.println("Message envoye");
		retourMenu();
	}

	/*
	 * Methodes appartement
	 */
	
	public static void rendreDispo() {
		// Test OK
		List<Logement> logementsDuProprio = Context.getInstance().getDaoLogement().findAllByIdProprio(Context.getInstance().getUtilisateurConnecte().getId());
		System.out.println("Voici la liste de vos logements : ");
		for(Logement l : logementsDuProprio) {
			System.out.println("Logement numero " + l.getId() + " situé " + l.getLocalisation().getNum() + " " + l.getLocalisation().getVoie() + " " + l.getLocalisation().getVille());
		}
		int choix = Context.getInstance().saisieInt("Dans quel logement souhaitez vous liberer une chambre : ");
		Logement logementALiberer = Context.getInstance().getDaoLogement().findById(choix);
		List<Chambre> chambresDuLogement = Context.getInstance().getDaoChambre().findAllByIdLogement(logementALiberer.getId());
		System.out.println("Voici les chambres du logement : ");
		List<Locataire> locatairesDesChambres = new ArrayList();
		for(Chambre c : chambresDuLogement) {
			Locataire loc = Context.getInstance().getDaoLocataire().findByIdChambre(c.getId());
			locatairesDesChambres.add(loc);
			if(loc == null) {
				System.out.println("Chambre numero " + c.getId() + " inoccupee");
			} else {
				System.out.println("Chambre numero " + c.getId() + " occupee par " + loc.getNom() + " " + loc.getPrenom());
			}
		}
		choix = Context.getInstance().saisieInt("Quelle chambre souhaitez vous liberer : ");
		Chambre chambreALiberer = Context.getInstance().getDaoChambre().findById(choix);
		if(chambreALiberer.getLocataire() != null) {
			Locataire locataireChambreALiberer = Context.getInstance().getDaoLocataire().findByIdChambre(choix);
			locataireChambreALiberer.setChambre(null);
			chambreALiberer.setLocataire(null);
			Context.getInstance().getDaoChambre().save(chambreALiberer);
			Context.getInstance().getDaoLocataire().save(locataireChambreALiberer);
			System.out.println("Chambre liberee");
		} else {
			System.out.println(("Cette chambre est deja inoccupee"));
		}
		retourMenu();
	}
	
	/*
	 * Methodes logement
	 */
	
private static Logement choisirLogement(){
		
		Logement logementChoisi=null;
		Utilisateur connected = Context.getInstance().getUtilisateurConnecte();
		List<Logement> listeLogements = Context.getInstance().getDaoLogement().findAllByIdProprio(connected.getId());
		
		for(int i=0;i<listeLogements.size();i++)
		{
			Logement logement = listeLogements.get(i);
			System.out.println((i+1)+ " : " +logement.getTypeLogement()+ " à " +logement.getLocalisation().getVille()+ "(" +logement.getLocalisation().getCodePostal()+ ") au " +logement.getLocalisation().getNum()+ " " +logement.getLocalisation().getVoie());

		}

		boolean fin=false;
		do {
			try {
				int choixLogement = Context.getInstance().saisieInt("Quel logement souhaitez-vous choisir ?");
				logementChoisi = listeLogements.get(choixLogement-1);
				fin=true;
				
			}
			catch (Exception e) {System.out.println("***ERREUR*** : Entrer un numero de logement");}
		}
		while(!fin);
		
		return logementChoisi;
	
	}
	
	private static Chambre choisirChambre(Logement logement){
		
		Chambre chambreChoisie=null;
		List<Chambre> chambres = Context.getInstance().getDaoChambre().findAllByIdLogement(logement.getId());
		
		for(int j=0;j<chambres.size();j++)
		{
			Chambre chambre = chambres.get(j);
			System.out.println((j+1)+ " : " +chambre.getSurface()+ "m² ," +chambre.getLoyer() + "€, dispo le " +logement.getDateDispo());

		}

		boolean fin=false;
		do {
			try {
				int choixChambre = Context.getInstance().saisieInt("Quel chambre souhaitez-vous choisir ?");
				chambreChoisie = chambres.get(choixChambre-1);
				fin=true;
				
			}
			catch (Exception e) {System.out.println("***ERREUR*** : Entrer un numero de chambre");}
		}
		while(!fin);
		
		return chambreChoisie;
	
	}
	
	private static void modifAppart() {
		// TODO Auto-generated method stub
		Logement logement = choisirLogement();
		
		
		System.out.println("1 - La description");
		System.out.println("2 - Le loyer");
		System.out.println("3 - La date de disponibilité");
		System.out.println("4 - Le nombre de chambres");
		System.out.println("5 - Le nombre de chambres occupées");
		System.out.println("6 - Le nombre de salles de bain");
		System.out.println("7 - Le type de logement");
		System.out.println("8 - La durée minimum du bail");
		System.out.println("9 - La localisation");
		System.out.println("10 - Une chambre du logement");
		System.out.println("11 - Fin des modifications");
	
		int choix = Context.getInstance().saisieInt("Que souhaitez-vous modifier ?");

		String modif = null;
		int modifInt=0;
		Double modifDouble=0.0;

		if(choix==11) {logement=null;menuProprietaire();}

		else if(choix==2) { 
			modifDouble=Context.getInstance().saisieDouble("saisir modif");
			logement.setLoyer(modifDouble);
		}

		else if(choix==4 || choix==5 || choix==6 || choix==8) { 
			modifInt=Context.getInstance().saisieInt("saisir modif");
			switch(choix) 
			{
			case 4 : logement.setnChambre(modifInt);break;
			case 5 : logement.setnChambreOccup(modifInt);break;
			case 6 : logement.setnSdb(modifInt);break;
			case 8 : logement.setDureeMini(modifInt);break;

			}
		}
		else if (choix==3) {
			
			modif=Context.getInstance().saisieString("saisir modif (aaa-mm-jj)");
			logement.setDateDispo(LocalDate.parse(modif));
		}
		else if (choix==9) {
			
		/*	System.out.println("1 - Le departement");
			System.out.println("2 - La ville");
			System.out.println("3 - Le code postal");
			System.out.println("4 - La voie");
			System.out.println("5 - Le numéro de voie");
			
			int choixLoc = Context.getInstance().saisieInt("Que souhaitez-vous modifier ?");
			switch(choix) 
			{
			case 1 :String departement = Context.getInstance().saisieString("Saisir le departement");
			case 2 :String ville = Context.getInstance().saisieString("Saisir la ville");
			case 3 :String CP = Context.getInstance().saisieString("Saisir le code postal");
			case 4 :String voie = Context.getInstance().saisieString("Saisir la voie");
			case 5 :Int num = Context.getInstance().saisieInt("Saisir le numero de voie");
			}*/
			
			String departement = Context.getInstance().saisieString("Saisir le departement");
			String ville = Context.getInstance().saisieString("Saisir la ville");
			String CP = Context.getInstance().saisieString("Saisir le code postal");
			String voie = Context.getInstance().saisieString("Saisir la voie");
			int num = Context.getInstance().saisieInt("Saisir le numéro de voie");
			Localisation newLocalisation = new Localisation(departement, ville, CP, voie, num);
			newLocalisation = Context.getInstance().getDaoLocalisation().save(newLocalisation);
			logement.setLocalisation(newLocalisation);
		}
		else if(choix==10) {
			
		modifChambre(logement);

		}
		
		else {
			modif = Context.getInstance().saisieString("Saisir la modif");
			switch(choix) 
			{
			case 1 : logement.setDescription(modif);break;
			case 3 : logement.setDateDispo(LocalDate.parse(modif));break;
			case 7 : logement.setTypeLogement(TypeLogement.valueOf(modif));break;
		
			}
		}

		Context.getInstance().getDaoLogement().save(logement);
		System.out.println("Modification(s) effectuée(s) \n Retour menu...");
		retourMenu();
	}

	
	public static void modifChambre(Logement logement) {
		Chambre chambre = choisirChambre(logement);
		
		System.out.println("1 - Le loyer");
		System.out.println("2 - Date de disponibilité");
		System.out.println("3 - La surface");
		System.out.println("4 - Charges");
		System.out.println("5 - Caution");
		System.out.println("6 - Durée minimum");
		
		int choix = Context.getInstance().saisieInt("Que souhaitez-vous modifier ?");

		String modif = null;
		int modifInt=0;
		Double modifDouble=0.0;

		
		if(choix==1|| choix == 4 || choix == 5) { 
			modifDouble=Context.getInstance().saisieDouble("saisir modif");
			chambre.setLoyer(modifDouble);
		}
		else if (choix==2 ) {
			
			modif=Context.getInstance().saisieString("saisir modif (aaa-mm-jj)");
			chambre.setDateDispo(LocalDate.parse(modif));
		}
		else if (choix==3 || choix==6) {
			modifInt=Context.getInstance().saisieInt("saisir la modif");
		}
		else {
			modif=Context.getInstance().saisieString("saisir modif");
		}
		
		Context.getInstance().getDaoChambre().save(chambre);
	}
	
	public static void ajoutAppart() {
		
		System.out.println("Ajout d'un nouveau logement");
		
		
		/* Localisation */
		
		System.out.println("Localisation de l'appartement : ");
		
		String villeNew = Context.getInstance().saisieString("Ajouter la ville : ");
		String codePostalNew = Context.getInstance().saisieString("Ajouter le code postal ");
		
		String voieNew="";
		String departementNew ="";
		int numNew = 0;
	
		departementNew = Context.getInstance().saisieString("Ajouter le departement ");
		voieNew = Context.getInstance().saisieString("Ajouter le nom de la voie ");
		boolean fin = false;
		do
		{
			try
			{numNew = Context.getInstance().saisieInt("Ajouter le numero de la voie ");
			fin = true;}
			catch(Exception e) {System.out.println("***ERREUR*** : entrer un numero de voie");}
		}
		while(!fin);
		
		Localisation newLocalisation = new Localisation(departementNew,villeNew,codePostalNew,voieNew,numNew);
		newLocalisation = Context.getInstance().getDaoLocalisation().save(newLocalisation);
		
		
		
		/* Type logement */
		
		
		
		System.out.println("Type de logement : ");
		
		TypeLogement[] typeLogement = TypeLogement.values();
		for(int i=0;i<typeLogement.length;i++)
		{
			System.out.println( typeLogement[i]);
		}
		
		String typeNew="";
		String choix="o";

		while(choix.equals("o"))
		{
			try 
			{
				typeNew = Context.getInstance().saisieString("Entrer le type du logement : ");
				for(TypeLogement t : typeLogement)
				{
					if(typeNew.equals(t.toString())) {choix="n";}
				}
			}
			catch(Exception e) {System.out.println("***ERREUR*** : entrer un type valide");}
			if(choix.equals("o")){System.out.println("***ERREUR*** : entrer un type valide");}
		}
		
		
		
		
		/* INFOS Logement */
		
		
		
		System.out.println("Informations sur le logement : ");
		
		
		int surface=0;
		Double loyer=0.0;
		fin=false;
		do {
			try 
			{surface = Context.getInstance().saisieInt("Entrer la surface totale du logement (m2) : ");
			loyer = Context.getInstance().saisieDouble("Entrer le loyer : ");
			fin = true;}
			catch(Exception e) {System.out.println("***ERREUR*** : entrer uniquement des nombres");}
		}while(!fin);
		
		int nbChambre = 0;
		int nbChambreOccup = 0;
		fin=false;
		do {
			try 
			{nbChambre = Context.getInstance().saisieInt("Entrer le nombre de chambre : ");
			nbChambreOccup = Context.getInstance().saisieInt("Entrer le nombre de chambre occupee : ");
			fin=true;}
			catch(Exception e) {System.out.println("***ERREUR*** : entrer uniquement des nombres");}
		}while(!fin);
		
		int nbSdB = 0;
		fin = false;
		do {
			try {nbSdB = Context.getInstance().saisieInt("Entrer le nombre de salle de bain : ");fin=true;}
			catch(Exception e) {System.out.println("***ERREUR*** : entrer uniquement des nombres");}
		}while(!fin);
		
		
		
		
		//Commodites
		
		
		
		String commodite = Context.getInstance().saisieString("Ajouter d'autres commoditees au logement (o/n)? (balcon, terrasse, WiFi, cave,...)");
		
		List<Commodite> listeCommodites = new ArrayList();
		
		if(commodite.equals("o")) 
		{
			System.out.println("Ajouter les commodites une par une (STOP pour finir) :");
			while(!(commodite.equals("STOP")))
			{
				commodite = Context.getInstance().saisieString("- " );
				if(!(commodite.equals("STOP"))) 
				{
					Commodite newCommodite = new Commodite(commodite);
					newCommodite = Context.getInstance().getDaoCommodite().save(newCommodite);
					listeCommodites.add(newCommodite);
				}
			}
		}
		
		
		
		//Description
		
		
		String description = Context.getInstance().saisieString("Ajouter un texte de description a l'appartement (o/n) ?");
		
		if(description.equals("o"))
		{
			description = Context.getInstance().saisieString("Entrer la description : ");
		}
		else {description = "";}
		
		
		

		//Regles
		
		
		
		String regle = Context.getInstance().saisieString("Ajouter des regles a l'appartement (o/n) ?");
		List<Regle> listeRegles = new ArrayList();
		
		if(regle.equals("o")) 
		{
			System.out.println("Ajouter les regles une par une (STOP pour finir) :");
			while(!(regle.equals("STOP")))
			{
				regle = Context.getInstance().saisieString("- " );
				if(!(regle.equals("STOP"))) 
				{
					Regle newRegle = new Regle(regle);
					newRegle = Context.getInstance().getDaoRegle().save(newRegle);
					listeRegles.add(newRegle);
				}
			}
		}
		
		
		Utilisateur connected = Context.getInstance().getUtilisateurConnecte();
		
		
		
		Logement newLogement = new Logement((Proprietaire) connected, description,surface,nbChambre,nbChambreOccup,nbSdB,loyer,newLocalisation,TypeLogement.valueOf(typeNew),listeCommodites,listeRegles);
		newLogement = Context.getInstance().getDaoLogement().save(newLogement);
		
		
		
		//CARACTERISTIQUES Chambres
		
		
		
		System.out.println("Caracteristiques des chambres : ");
		
		String chambre = Context.getInstance().saisieString("Renseigner les chambres (o/n)  ? ");
		
		List<Chambre> listeChambres = new ArrayList();
		
		
		if(chambre.equals("o"))
		{
			for(int i=1;i<=nbChambre;i++)
			{
				System.out.println("Chambre n� " + i);
				String dateDispoChambre = Context.getInstance().saisieString("Date de disponbilite (aaaa-mm-jj)  :");
				int surfaceChambre = Context.getInstance().saisieInt("Surface : ");
				Double loyerChambre = Context.getInstance().saisieDouble("Loyer : ");
				Double chargeChambre = Context.getInstance().saisieDouble("Charges : ");
				Double cautionChambre = Context.getInstance().saisieDouble("Caution : ");
				int dureeMiniChambre = Context.getInstance().saisieInt("Duree mini de location (mois) : ");
				
				String commoditeChambre = Context.getInstance().saisieString("Ajouter des commodites a la chambre (o/n) ? ");
				
				List<Commodite> listeCommoditesChambre = new ArrayList();
				
				if(commoditeChambre.equals("o")) {System.out.println("Ajouter les commodites une par une (STOP pour finir) :");}
				while(!(commoditeChambre.equals("STOP")))
				{
					commoditeChambre = Context.getInstance().saisieString("- " );
					if(!(commoditeChambre.equals("STOP"))) 
					{
						Commodite newCommoditeChambre = new Commodite(commoditeChambre);
						newCommoditeChambre = Context.getInstance().getDaoCommodite().save(newCommoditeChambre);
						listeCommoditesChambre.add(newCommoditeChambre);
					}
				}
				Chambre newChambre = new Chambre(newLogement,surfaceChambre,loyerChambre,chargeChambre,cautionChambre,dureeMiniChambre,LocalDate.parse(dateDispoChambre),listeCommoditesChambre);
				newChambre = Context.getInstance().getDaoChambre().save(newChambre);
			}
		}
		
		System.out.println("Nouveau logement ajoute !");
		retourMenu();
	}
	
	
	/*
	 * Methode visualisation des appartements disponibles
	 */
	
	public static void voirAnnonce () {
		//Test OK
		List<Logement> logements = Context.getInstance().getDaoLogement().findAllByAvailabilityWithProprio();
		for(Logement l : logements) {
			System.out.println(l);
		}
		retourMenu();
	}

	
	/*
	 * Methode visualisation & validation des dossiers
	 */
	
	public static void voirDossier() {
		
		System.out.println("Vos logements enregistres : ");
		
		Utilisateur connected = Context.getInstance().getUtilisateurConnecte();
		List<Logement> listeLogements = Context.getInstance().getDaoLogement().findAllByIdProprio(connected.getId());
		
		for(int i=0;i<listeLogements.size();i++)
		{
			Logement logement = listeLogements.get(i);
			System.out.println((i+1)+ " : " +logement.getTypeLogement()+ " a " +logement.getLocalisation().getVille()+ "(" +logement.getLocalisation().getCodePostal()+ ") au " +logement.getLocalisation().getNum()+ " " +logement.getLocalisation().getVoie());
			
		}
		
		boolean fin=false;
		do {
			try {
				int choixLogement = Context.getInstance().saisieInt("Quel logement souhaitez-vous choisir ?");
				fin=true;
			}
			catch (Exception e) {System.out.println("***ERREUR*** : Entrer un numero de logement");}
		}
		while(!fin);		
	}
	
	/*
	 * Methode noter l'appartement
	 */
	
	public static void noterAppart() {
		// Test OK
		Locataire locataire = (Locataire) Context.getInstance().getUtilisateurConnecte();
		if(locataire.getChambre() != null) {
			Double note = Context.getInstance().saisieDouble("Saississez votre note (/10): ");
			String commentaire = Context.getInstance().saisieString("Saississez votre commentaire : ");
			Notation newNotation = new Notation(locataire.getChambre().getLogement(),locataire, note, commentaire);
			newNotation = Context.getInstance().getDaoNotation().save(newNotation);
			System.out.println("Notation envoyee");
		} else {
			System.out.println("Aucune chambre n'est associee a votre profil");
		}
		retourMenu();
	}	
	
	/*
	 *  Main
	 */
	
	public static void main(String[] args) {
		
		menuPrincipal();

	}	
	
}
