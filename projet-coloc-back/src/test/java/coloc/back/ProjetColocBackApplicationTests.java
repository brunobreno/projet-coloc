package coloc.back;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import coloc.back.model.Chambre;
import coloc.back.model.Civilite;
import coloc.back.model.Commodite;
import coloc.back.model.Dossier;
import coloc.back.model.Hobby;
import coloc.back.model.Localisation;
import coloc.back.model.Locataire;
import coloc.back.model.Logement;
import coloc.back.model.Message;
import coloc.back.model.Notation;
import coloc.back.model.Photo;
import coloc.back.model.Proprietaire;
import coloc.back.model.Regle;
import coloc.back.model.Situation;
import coloc.back.model.TypeLogement;
import coloc.back.repository.IChambreRepository;
import coloc.back.repository.ICommoditeRepository;
import coloc.back.repository.IHobbyRepository;
import coloc.back.repository.ILocataireRepository;
import coloc.back.repository.ILogementRepository;
import coloc.back.repository.IMessageRepository;
import coloc.back.repository.INotationRepository;
import coloc.back.repository.IPhotoRepository;
import coloc.back.repository.IProprietaireRepository;
import coloc.back.repository.IRegleRepository;

@SpringBootTest
class ProjetColocBackApplicationTests {

	@Autowired
	private IProprietaireRepository proprietaireRepository;
	@Autowired
	private ILocataireRepository locataireRepository;
	@Autowired
	private ILogementRepository logementRepository;
	@Autowired
	private IChambreRepository chambreRepository;
	@Autowired
	private IMessageRepository messageRepository;
	@Autowired
	private INotationRepository notationRepository;
	@Autowired
	private IRegleRepository regleRepository;
	@Autowired
	private ICommoditeRepository commoditeRepository;
	@Autowired
	private IPhotoRepository photoRepository;
	@Autowired
	private IHobbyRepository hobbyRepository;
	
	String Lorem ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, ";

			
	@Test
	void contextLoads() {
		//Creation Admin
		Proprietaire admin = new Proprietaire("admin", "adminNom", "adminPrenom", Civilite.NB, "admin@mail.com", "0000000000", "admin");
		admin = proprietaireRepository.save(admin);

		// Creation des Proprio
		Proprietaire proprietaire1 = new Proprietaire("proprietaire1", "Bastier", "Bruno", Civilite.Mr,
				"bruno@mail.com", "0000000001", "proprietaire1");
		proprietaire1 = proprietaireRepository.save(proprietaire1);
		Proprietaire proprietaire2 = new Proprietaire("proprietaire2", "Faurie", "Emma", Civilite.Mme,
				"emma@mail.com", "0000000002", "proprietaire2");
		proprietaire2 = proprietaireRepository.save(proprietaire2);
		Proprietaire proprietaire3 = new Proprietaire("proprietaire3", "Nguyen", "Guillaume", Civilite.Mr,
				"guillaume@mail.com", "0000000003", "proprietaire3");
		proprietaire3 = proprietaireRepository.save(proprietaire3);
		Proprietaire proprietaire4 = new Proprietaire("proprietaire4", "Revillion", "Estelle", Civilite.Mme,
				"estelle@mail.com", "0000000004", "proprietaire4");
		proprietaire4 = proprietaireRepository.save(proprietaire4);

		// Creation des Locataire
		Locataire locataire1 = new Locataire("monica", "Geller", "Monica", Civilite.Mme, "monicageller@mail.com",
				"0101010101", "monica", false, 
				"Maniaque mais veut absolument organiser toutes les soirées chez elle. Cuisine hyper bien et nourrit tout le monde", 
				Situation.Salarie,  LocalDate.parse("1969-03-09"));
		locataire1 = locataireRepository.save(locataire1);
		Locataire locataire2 = new Locataire("rachel", "Green", "Rachel", Civilite.Mme, "rachelgreen@mail.com",
				"0202020202", "rachel", false, "Bordélique et enfant gâtée mais peut t'habiller comme personne", Situation.Autre, LocalDate.parse("1969-05-05"));
		locataire2 = locataireRepository.save(locataire2);
		Locataire locataire3 = new Locataire("jaxx", "Abid", "Jordan", Civilite.Mr, "jordanabid@mail.com",
				"0303030303", "jaxx", true, "Peut hypnotiser le propriétaire pour avoir un appartement. C'est aussi bizarre qu'il ait les réfs de tous les jeux vidéos du monde nan ?", Situation.Salarie, LocalDate.parse("1992-02-09"));
		locataire3 = locataireRepository.save(locataire3);
		Locataire locataire4 = new Locataire("locataire4", "NomLocataire4", "PrenomLocataire4", Civilite.Mr, "locataire4@mail.com",
				"0011000004", "locataire4", false, "Description locataire 4" + Lorem, Situation.Retraite, LocalDate.parse("1992-02-09"));
		locataire4 = locataireRepository.save(locataire4);
		Locataire locataire5 = new Locataire("locataire5", "NomLocataire5", "PrenomLocataire5", Civilite.Mme, "locataire5@mail.com",
				"0011000005", "locataire5", false, "Description locataire 5" + Lorem, Situation.Etudiant, LocalDate.parse("1992-02-09"));
		locataire5 = locataireRepository.save(locataire5);
		Locataire locataire6 = new Locataire("locataire6", "NomLocataire6", "PrenomLocataire6", Civilite.Mme, "locataire6@mail.com",
				"0011000006", "locataire6", true, "Description locataire 6" + Lorem, Situation.Etudiant, LocalDate.parse("1992-02-09"));
		locataire6 = locataireRepository.save(locataire6);
		Locataire locataire7 = new Locataire("locataire7", "NomLocataire7", "PrenomLocataire7", Civilite.Mr, "locataire7@mail.com",
				"0011000007", "locataire7", true, "Description locataire 7" + Lorem , Situation.Salarie, LocalDate.parse("1992-02-09"));
		locataire7 = locataireRepository.save(locataire7);
		Locataire locataire8 = new Locataire("locataire8", "NomLocataire8", "PrenomLocataire8", Civilite.Mme, "locataire8@mail.com",
				"0011000008", "locataire8", true, "Description locataire 8" + Lorem, Situation.Salarie, LocalDate.parse("1992-02-09"));
		locataire8 = locataireRepository.save(locataire8);
		
		

		// Creation des Localisation
		Localisation locLog1 = new Localisation("New York", "West Village", "10014", "Bedford Street", 90);
		Localisation locLog2 = new Localisation("departementLog2", "villeLog2", "cpLog2", "voieLog2", 2);
		Localisation locLog3 = new Localisation("departementLog3", "villeLog3", "cpLog3", "voieLog3", 3);
		Localisation locLog4 = new Localisation("departementLog4", "villeLog4", "cpLog4", "voieLog4", 4);

		// Creation des Logement
		Logement log1 = new Logement(proprietaire1, "Grand appart central à New York", "Beaucoup trop grand pour le prix et très bien agencé", 104, 2, 2, 1, 180.0, 50.0, 300.0, locLog1,
				TypeLogement.Appartement, LocalDate.now(), false);
		log1 = logementRepository.save(log1);
		Logement log2 = new Logement(proprietaire2,"Titre log2", "Description log2" + Lorem, 40, 1, 0, 1, 350.0, 50.0, 350.0, locLog1,
				TypeLogement.Studio, LocalDate.now(), true);
		log2 = logementRepository.save(log2);
		Logement log3 = new Logement(proprietaire3,"Titre log3", "Description log3" + Lorem, 110, 4, 0, 1, 275.0, 50.0, 275.0, locLog3,
				TypeLogement.Maison, LocalDate.now(), false);
		log3 = logementRepository.save(log3);
		Logement log4 = new Logement(proprietaire4,"Titre log4", "Description log4" + Lorem, 35, 2, 0, 1, 325.0, 50.0, 325.0, locLog4,
				TypeLogement.Studio, LocalDate.now(), true);
		log4 = logementRepository.save(log4);

		// Creation des Commodites
		Commodite balcon = new Commodite("balcon","balcon.svg");
		balcon = commoditeRepository.save(balcon);
		Commodite jardin = new Commodite("jardin","jardin.svg");
		jardin = commoditeRepository.save(jardin);
		Commodite terrasse = new Commodite("terrasse","terrasse.svg");
		terrasse = commoditeRepository.save(terrasse);
		Commodite handicape = new Commodite("acces handicape","handi.svg");
		handicape = commoditeRepository.save(handicape);
		Commodite parking = new Commodite("parking","parking.svg");
		parking = commoditeRepository.save(parking);
		Commodite salleDeSport = new Commodite("salle de sport","sport.svg");
		salleDeSport = commoditeRepository.save(salleDeSport);
		Commodite fibre = new Commodite("internet fibre","fibre.svg");
		fibre = commoditeRepository.save(fibre);
		Commodite climatisation = new Commodite("climatisation","climatisation.svg");
		climatisation = commoditeRepository.save(climatisation);
		Commodite television = new Commodite("television","television.svg");
		television = commoditeRepository.save(television);
		Commodite laveLinge = new Commodite("lave linge","lave-linge.svg");
		laveLinge = commoditeRepository.save(laveLinge);
		Commodite laveVaiselle = new Commodite("lave vaisselle","lave-vaisselle.svg");
		laveVaiselle = commoditeRepository.save(laveVaiselle);

		// Creation des Regle
		Regle fumeurAutorise = new Regle("fumeur autorise","fumeur.svg");
		fumeurAutorise = regleRepository.save(fumeurAutorise);
		Regle animauxAutorises = new Regle("animaux autorises","animaux.svg");
		animauxAutorises = regleRepository.save(animauxAutorises);
		Regle femmeUniquement = new Regle("femme uniquement","femme.svg");
		femmeUniquement = regleRepository.save(femmeUniquement);
		Regle hommeUniquement = new Regle("homme uniquement","homme.svg");
		hommeUniquement = regleRepository.save(hommeUniquement);
		Regle passSanitaire = new Regle("pass sanitaire","sanitaire.svg");
		passSanitaire = regleRepository.save(passSanitaire);
		Regle salarie = new Regle("Pas d'étudiants","salarie.svg");
		salarie = regleRepository.save(salarie);
		
		// Creation des Hobbies
		Hobby art = new Hobby("Art","art.svg");
		art = hobbyRepository.save(art);
		Hobby dessin = new Hobby("Dessin","dessin.svg");
		dessin = hobbyRepository.save(dessin);
		Hobby photographie = new Hobby("Photographie","photographie.svg");
		photographie = hobbyRepository.save(photographie);
		Hobby lecture = new Hobby("Lecture","lecture.svg");
		lecture = hobbyRepository.save(lecture);

		
		Hobby sport = new Hobby("Sport","sport.svg");
		sport = hobbyRepository.save(sport);
		Hobby sportEquipe = new Hobby("Sport d'équipe","sportEquipe.svg");
		sportEquipe = hobbyRepository.save(sportEquipe);
		
		Hobby bars = new Hobby("Bars","bars.svg");
		bars = hobbyRepository.save(bars);
		Hobby nightLife = new Hobby("Night life","nightLife.svg");
		nightLife = hobbyRepository.save(nightLife);

		
		Hobby cuisine = new Hobby("Cuisine","cuisine.svg");
		cuisine = hobbyRepository.save(cuisine);
		Hobby jardinage = new Hobby("Jardinage","jardinage.svg");
		jardinage = hobbyRepository.save(jardinage);
		Hobby jeuxVidéo = new Hobby("Jeux vidéo","jeuxVidéo.svg");
		jeuxVidéo = hobbyRepository.save(jeuxVidéo);
		Hobby jeuxSociete = new Hobby("Jeux de Societe","jeuxSociete.svg");
		jeuxSociete = hobbyRepository.save(jeuxSociete);
		
		Hobby cinema = new Hobby("Cinema","cinema.svg");
		cinema = hobbyRepository.save(cinema);
		Hobby musique = new Hobby("Musique","musique.svg");
		musique = hobbyRepository.save(musique);
		Hobby guitare = new Hobby("Guitare","guitare.svg");
		guitare = hobbyRepository.save(guitare);
		
		Hobby vegetarien = new Hobby("Vegetarien","vegetarien.svg");
		vegetarien = hobbyRepository.save(vegetarien);
		Hobby ecologie = new Hobby("Ecologie","ecologie.svg");
		ecologie = hobbyRepository.save(ecologie);
		
		Hobby voyage = new Hobby("Voyage","voyage.svg");
		voyage = hobbyRepository.save(voyage);
		Hobby randonnée = new Hobby("Randonnée","randonnée.svg");
		randonnée = hobbyRepository.save(randonnée);
		Hobby pleinAir = new Hobby("Plein air","pleinAir.svg");
		pleinAir = hobbyRepository.save(pleinAir);
		
		Hobby animaux = new Hobby("Animaux","animaux.svg");
		animaux = hobbyRepository.save(animaux);
		
		locataire1.addHobby(cuisine);
		locataire1.addHobby(musique);
		locataire1.addHobby(lecture);
		locataire1 = locataireRepository.save(locataire1);


		// Creation des Notation
		Notation noteLoc1Lg1 = new Notation(log1, locataire1, 15.0, "commentaire note loc1 pour log1");
		noteLoc1Lg1 = notationRepository.save(noteLoc1Lg1);
		Notation noteLoc2Lg1 = new Notation(log1, locataire2, 10.0, "commentaire note loc2 pour log1");
		noteLoc2Lg1 = notationRepository.save(noteLoc2Lg1);
		Notation noteLoc3Lg2 = new Notation(log2, locataire3, 7.0, "commentaire note loc3 pour log2");
		noteLoc3Lg2 = notationRepository.save(noteLoc3Lg2);
		Notation noteLoc4Lg2 = new Notation(log2, locataire4, 15.0, "commentaire note loc4 pour log2");
		noteLoc4Lg2 = notationRepository.save(noteLoc4Lg2);
		Notation noteLoc5Lg4 = new Notation(log4, locataire5, 18.0, "commentaire note loc5 pour log4");
		noteLoc5Lg4 = notationRepository.save(noteLoc5Lg4);
		Notation noteLoc6Lg4 = new Notation(log4, locataire6, 10.0, "commentaire note loc5 pour log4");
		noteLoc6Lg4 = notationRepository.save(noteLoc6Lg4);
		Notation noteLoc7Lg4 = new Notation(log4, locataire7, 11.0, "commentaire note loc5 pour log4");
		noteLoc7Lg4 = notationRepository.save(noteLoc7Lg4);
		Notation noteLoc8Lg4 = new Notation(log4, locataire8, 8.0, "commentaire note loc5 pour log4");
		noteLoc8Lg4 = notationRepository.save(noteLoc8Lg4);

		// Creation des Chambre
		Chambre ch1Log1 = new Chambre(log1, 12, "description chambre 1 Log 1");
		ch1Log1 = chambreRepository.save(ch1Log1);
		Chambre ch2Log1 = new Chambre(log1, 13,  "description chambre 2 Log 1");
		ch2Log1 = chambreRepository.save(ch2Log1);
		Chambre ch1Log2 = new Chambre(log2, 15,  "description chambre 1 Log 2");
		ch1Log2 = chambreRepository.save(ch1Log2);
		Chambre ch1Log3 = new Chambre(log3, 10, "description chambre 1 Log 3");
		ch1Log3 = chambreRepository.save(ch1Log3);
		Chambre ch2Log3 = new Chambre(log3, 12, "description chambre 2 log 3");
		ch2Log3 = chambreRepository.save(ch2Log3);
		Chambre ch3Log3 = new Chambre(log3, 14, "description chambre 3 log 3");
		ch3Log3 = chambreRepository.save(ch3Log3);
		Chambre ch4Log3 = new Chambre(log3, 13, "description chambre 4 log 3");
		ch4Log3 = chambreRepository.save(ch4Log3);
		Chambre ch1Log4 = new Chambre(log4, 12, "description chambre 1 log 4");
		ch1Log4 = chambreRepository.save(ch1Log4);
		Chambre ch2Log4 = new Chambre(log4, 16, "description chambre 2 log 4");
		ch2Log4 = chambreRepository.save(ch2Log4);

		// Creation des Messages
		Message message1Loc1proprietaire1 = new Message(locataire1, proprietaire1,
				"Premier message loc1 vers proprietaire1");
		message1Loc1proprietaire1 = messageRepository.save(message1Loc1proprietaire1);
		Message message1proprietaire1Loc1 = new Message(proprietaire1, locataire1,
				"Premier message proprietaire1 vers loc1");
		message1proprietaire1Loc1 = messageRepository.save(message1proprietaire1Loc1);
		Message message2Loc1proprietaire1 = new Message(locataire1, proprietaire1,
				"Premier message loc1 vers proprietaire1");
		message2Loc1proprietaire1 = messageRepository.save(message2Loc1proprietaire1);
		Message message1Loc3proprietaire2 = new Message(locataire3, proprietaire2,
				"Premier message loc3 vers proprietaire2");
		message1Loc3proprietaire2 = messageRepository.save(message1Loc3proprietaire2);
		Message message1proprietaire2Loc3 = new Message(proprietaire2, locataire3,
				"Premier message proprietaire2 vers loc3");
		message1proprietaire2Loc3 = messageRepository.save(message1proprietaire2Loc3);
		Message message1Loc7proprietaire4 = new Message(locataire7, proprietaire4,
				"Premier message loc7 vers proprietaire4");
		message1Loc7proprietaire4 = messageRepository.save(message1Loc7proprietaire4);

		// Creation des Dossier
		Dossier dossierLoc1 = new Dossier(1500.0, 2200.0, Situation.Salarie);
		locataire1.setDossier(dossierLoc1);
		locataire1 = locataireRepository.save(locataire1);
		Dossier dossierLoc2 = new Dossier(1500.0, 2200.0, Situation.Retraite);
		locataire2.setDossier(dossierLoc2);
		locataire2 = locataireRepository.save(locataire2);
		Dossier dossierLoc4 = new Dossier(0.0, 2500.0, Situation.Salarie);
		locataire4.setDossier(dossierLoc4);
		locataire4 = locataireRepository.save(locataire4);
		Dossier dossierLoc5 = new Dossier(800.0, 1600.0, Situation.Salarie);
		locataire5.setDossier(dossierLoc5);
		locataire5 = locataireRepository.save(locataire5);
		Dossier dossierLoc6 = new Dossier(1200.0, 1600.0, Situation.Salarie);
		locataire6.setDossier(dossierLoc6);
		locataire6 = locataireRepository.save(locataire6);
		Dossier dossierLoc7 = new Dossier(1000.0, 1800.0, Situation.Salarie);
		locataire7.setDossier(dossierLoc7);
		locataire7 = locataireRepository.save(locataire7);
		
		

		// Ajout de Commodite a Logement
		log1.addCommodite(balcon);
		log1.addCommodite(parking);
		log1.addCommodite(fibre);
		log1 = logementRepository.save(log1);
		log2.addCommodite(handicape);
		log2.addCommodite(parking);
		log2 = logementRepository.save(log2);
		log3.addCommodite(jardin);
		log3.addCommodite(parking);
		log3.addCommodite(fibre);
		log3 = logementRepository.save(log3);
		log4.addCommodite(fibre);
		log4.addCommodite(balcon);
		log4.addCommodite(salleDeSport);
		log4.addCommodite(handicape);
		log4 = logementRepository.save(log4);

		// Ajout de Regle a Logement
		log1.addRegle(fumeurAutorise);
		log1 = logementRepository.save(log1);
		log2.addRegle(animauxAutorises);
		log2 = logementRepository.save(log2);
		log3.addRegle(animauxAutorises);
		log3.addRegle(passSanitaire);
		log3 = logementRepository.save(log3);
		log4.addRegle(femmeUniquement);
		log4 = logementRepository.save(log4);

		// Ajout de Commodite a Chambre
		ch1Log1.addCommodites(balcon);
		ch1Log1.addCommodites(television);
		ch1Log1 = chambreRepository.save(ch1Log1);
		ch1Log4.addCommodites(television);
		ch1Log4 = chambreRepository.save(ch1Log4);

		// Ajout de Locataire a Chambre
		locataire1.setChambre(ch1Log1);
		locataire1 = locataireRepository.save(locataire1);
		locataire2.setChambre(ch2Log1);
		locataire2 = locataireRepository.save(locataire2);
		locataire5.setChambre(ch1Log3);
		locataire5 = locataireRepository.save(locataire5);
		locataire6.setChambre(ch2Log3);
		locataire6 = locataireRepository.save(locataire6);
		locataire7.setChambre(ch3Log3);
		locataire7 = locataireRepository.save(locataire7);
		log1.setnChambreOccup(2);
		log1.setDateDispo(null);
		log1 = logementRepository.save(log1);
		log3.setnChambreOccup(3);
		log3 = logementRepository.save(log3);

		// Ajout de Photo a Logement
		Photo photo1Log1 = new Photo("Photo1Log1", "logement1_1.png", 1, log1);
		photo1Log1 = photoRepository.save(photo1Log1);
		Photo photo2Log1 = new Photo("Photo2Log1", "logement1_2.png", 2, log1);
		photo2Log1 = photoRepository.save(photo2Log1);
		Photo photo3Log1 = new Photo("Photo3Log1", "logement1_3.jpg", 3, log1);
		photo3Log1 = photoRepository.save(photo3Log1);
		Photo photo4Log1 = new Photo("Photo4Log1", "logement1_4.jpg", 4, log1);
		photo4Log1 = photoRepository.save(photo4Log1);
		Photo photo5Log1 = new Photo("Photo5Log1", "logement1_5.jpg", 5, log1, ch1Log1);
		photo5Log1 = photoRepository.save(photo5Log1);
		Photo photo6Log1 = new Photo("Photo6Log1", "logement1_6.jpg", 6, log1, ch1Log1);
		photo6Log1 = photoRepository.save(photo6Log1);
		Photo photo7Log1 = new Photo("Photo7Log1", "logement1_7.jpg", 7, log1, ch2Log1);
		photo7Log1 = photoRepository.save(photo7Log1);
		Photo photo8Log1 = new Photo("Photo8Log1", "logement1_8.jpg", 8, log1, ch2Log1);
		photo8Log1 = photoRepository.save(photo8Log1);
		
		Photo photo1Log2 = new Photo("Photo1Log2", "logement2_1.png", 1, log2);
		photo1Log2 = photoRepository.save(photo1Log2);
		Photo photo2Log2 = new Photo("Photo2Log2", "logement2_2.png", 2, log2);
		photo2Log2 = photoRepository.save(photo2Log2);
		Photo photo3Log2 = new Photo("Photo3Log2", "logement2_3.jpg", 3, log2);
		photo3Log2 = photoRepository.save(photo3Log2);
		Photo photo4Log2 = new Photo("Photo4Log2", "logement2_4.jpg", 4, log2);
		photo4Log2 = photoRepository.save(photo4Log2);
		Photo photo1Log3 = new Photo("Photo1Log3", "logement3_1.png", 1, log3);
		photo1Log3 = photoRepository.save(photo1Log3);
		Photo photo2Log3 = new Photo("Photo2Log3", "logement3_2.png", 2, log3);
		photo2Log3 = photoRepository.save(photo2Log3);
		Photo photo3Log3 = new Photo("Photo3Log3", "logement3_3.jpg", 3, log3);
		photo3Log3 = photoRepository.save(photo3Log3);
		Photo photo4Log3 = new Photo("Photo4Log3", "logement3_4.jpg", 4, log3);
		photo4Log3 = photoRepository.save(photo4Log3);
		Photo photo1Log4 = new Photo("Photo1Log4", "logement4_1.jpg", 1, log4);
		photo1Log4 = photoRepository.save(photo1Log4);
		Photo photo2Log4 = new Photo("Photo2Log4", "logement4_2.jpg", 2, log4);
		photo2Log4 = photoRepository.save(photo2Log4);
		Photo photo3Log4 = new Photo("Photo3Log4", "logement4_3.jpg", 3, log4);
		photo3Log4 = photoRepository.save(photo3Log4);
		Photo photo4Log4 = new Photo("Photo4Log4", "logement4_4.png", 4, log4);
		photo4Log4 = photoRepository.save(photo4Log4);
		
		
		
		// NANTES
		
		
				
		
				// Creation des Proprio
				Proprietaire proprietaire5 = new Proprietaire("alexandreb", "Bertrand", "Alexandre", Civilite.Mr,
						"alexandre.bertrand@mail.com", "0695178452", "1234");
				proprietaire5 = proprietaireRepository.save(proprietaire5);
				Proprietaire proprietaire6 = new Proprietaire("charlotted", "Durand", "Charlotte", Civilite.Mme,
						"charlotte.durand@mail.com", "0658523695", "1234");
				proprietaire6 = proprietaireRepository.save(proprietaire6);
				Proprietaire proprietaire7 = new Proprietaire("gregorym", "Michel", "Gregory", Civilite.Mr,
						"gregory.michel@mail.com", "0658412658", "1234");
				proprietaire7 = proprietaireRepository.save(proprietaire7);
				
		

				// Creation des Localisation
				Localisation locLog5 = new Localisation("44", "Nantes", "44000", "Rue Racine", 20);
				Localisation locLog6 = new Localisation("44", "Nantes", "44000", "Rue du Calvaire", 25);
				Localisation locLog7 = new Localisation("44", "Nantes", "44000", "Rue Bertrand Geslin", 13);
				Localisation locLog8 = new Localisation("44", "Nantes", "44100", "Rue Dobree", 2);

				// Creation des Logement
				Logement log5 = new Logement(proprietaire5, "titre","Appartement pour 2 personnes. Situé rue Racine, animée et proche toute commodités", 70, 2, 0, 1, 300.0, 35.0, 300.0, locLog5,
						TypeLogement.Appartement, LocalDate.now(), false);
				log5 = logementRepository.save(log5);
				Logement log6 = new Logement(proprietaire5,"titre", "Appartement recemment rénové avec 3 chambres, dédié et pensé pour la colocation !" ,  80, 3, 0, 1, 400.0, 40.0, 400.0, locLog6,
						TypeLogement.Appartement, LocalDate.now(), true);
				log6 = logementRepository.save(log6);
				Logement log7 = new Logement(proprietaire6,"titre", "Grande maison avec 4 chambres et 2 salles de bain pour la colocation. Très lumineux et entièrement équipé !", 150, 4, 0, 2, 500.0, 25.0, 500.0, locLog7,
						TypeLogement.Maison, LocalDate.now(), true);
				log7 = logementRepository.save(log7);
				Logement log8 = new Logement(proprietaire7,"titre", "Appartement pour colocation à rue Dobree. 2 chambres de disponibles.", 65, 2, 0, 1, 425.0, 45.0, 425.0, locLog8,
						TypeLogement.Appartement, LocalDate.now(), true);
				log8 = logementRepository.save(log8);

			
				// Creation des Chambre
				Chambre ch1Log5 = new Chambre(log5, 12);
				ch1Log5 = chambreRepository.save(ch1Log5);
				Chambre ch2Log5 = new Chambre(log5, 13);
				ch2Log5 = chambreRepository.save(ch2Log5);
				
				Chambre ch1Log6 = new Chambre(log6, 15);
				ch1Log6 = chambreRepository.save(ch1Log6);
				Chambre ch2Log6 = new Chambre(log6, 15);
				ch2Log6 = chambreRepository.save(ch2Log6);
				Chambre ch3Log6 = new Chambre(log6, 15);
				ch3Log6 = chambreRepository.save(ch3Log6);
				
				Chambre ch1Log7 = new Chambre(log7, 10);
				ch1Log7 = chambreRepository.save(ch1Log7);
				Chambre ch2Log7 = new Chambre(log7, 12);
				ch2Log7 = chambreRepository.save(ch2Log7);
				Chambre ch3Log7 = new Chambre(log7, 14);
				ch3Log7 = chambreRepository.save(ch3Log7);
				Chambre ch4Log7 = new Chambre(log7, 13);
				ch4Log7 = chambreRepository.save(ch4Log7);
				
				Chambre ch1Log8 = new Chambre(log8, 12);
				ch1Log8 = chambreRepository.save(ch1Log8);
				Chambre ch2Log8 = new Chambre(log8, 16);
				ch2Log8 = chambreRepository.save(ch2Log8);

				

				// Ajout de Commodite a Logement
				log5.addCommodite(balcon);
				log5.addCommodite(parking);
				log5.addCommodite(fibre);
				log5 = logementRepository.save(log5);
				log6.addCommodite(handicape);
				log6.addCommodite(parking);
				log6 = logementRepository.save(log6);
				log7.addCommodite(jardin);
				log7.addCommodite(parking);
				log7.addCommodite(fibre);
				log7 = logementRepository.save(log7);
				log8.addCommodite(fibre);
				log8.addCommodite(balcon);
				log8.addCommodite(salleDeSport);
				log8.addCommodite(handicape);
				log8 = logementRepository.save(log8);

				// Ajout de Regle a Logement
				log5.addRegle(fumeurAutorise);
				log5 = logementRepository.save(log5);
				log6.addRegle(animauxAutorises);
				log6 = logementRepository.save(log6);
				log7.addRegle(animauxAutorises);
				log7.addRegle(passSanitaire);
				log7 = logementRepository.save(log7);
				log8.addRegle(femmeUniquement);
				log8 = logementRepository.save(log8);

				
		
		
	}

}
