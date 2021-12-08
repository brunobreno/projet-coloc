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
		// Creation des Proprios
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

		Proprietaire proprietaire5 = new Proprietaire("proprietaire5", "Brooks", "Finn", Civilite.Mr,
				"finn@mail.com", "0000000005", "proprietaire5");
		proprietaire5 = proprietaireRepository.save(proprietaire5);
		Proprietaire proprietaire6 = new Proprietaire("proprietaire6", "Michel", "Dan", Civilite.Mr,
				"dan@mail.com", "0000000006", "proprietaire6");
		proprietaire6 = proprietaireRepository.save(proprietaire6);
		Proprietaire proprietaire7 = new Proprietaire("proprietaire7", "Franck", "Erica", Civilite.Mme,
				"erica@mail.com", "0000000007", "proprietaire7");
		proprietaire7 = proprietaireRepository.save(proprietaire7);
		Proprietaire proprietaire8 = new Proprietaire("proprietaire8", "Dupont", "Michelle", Civilite.Mme,
				"michelle@mail.com", "0000000008", "proprietaire8");
		proprietaire8 = proprietaireRepository.save(proprietaire8);

		// Creation des Locataires
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
		Locataire locataire4 = new Locataire("didi", "Paul", "Didier", Civilite.Mr, "didier@mail.com",
				"0011000004", "didi", true, "Foot, bière, foot, bière, foot, bière, ...", Situation.Retraite, LocalDate.parse("1953-06-22"));
		locataire4 = locataireRepository.save(locataire4);
		Locataire locataire5 = new Locataire("mymy", "Tremblay", "Myriam", Civilite.Mme, "myriam@mail.com",
				"0011000005", "mymy", false, "Description Myriam Tremblay", Situation.Etudiant, LocalDate.parse("1996-02-23"));
		locataire5 = locataireRepository.save(locataire5);
		Locataire locataire6 = new Locataire("pierre", "Pierre", "Pierre", Civilite.Mr, "pierre@mail.com",
				"0011000006", "pierre", true, "Description Pierre Pierre", Situation.Etudiant, LocalDate.parse("1998-12-25"));
		locataire6 = locataireRepository.save(locataire6);
		Locataire locataire7 = new Locataire("fanny", "Becherel", "Fanny", Civilite.Mme, "locataire7@mail.com",
				"0011000007", "fanny", true, "Description Fanny Becherel", Situation.Salarie, LocalDate.parse("1980-11-11"));
		locataire7 = locataireRepository.save(locataire7);
		Locataire locataire8 = new Locataire("julien", "Kerautret", "Julien", Civilite.NB, "julien@mail.com",
				"0011000008", "julien", true, "Description Julien Kerautret", Situation.Salarie, LocalDate.parse("1990-10-01"));
		locataire8 = locataireRepository.save(locataire8);
		
		


		Locataire locataire9 = new Locataire("tony", "Stark", "Tony", Civilite.Mr, "tony@mail.com",
				"0101010101", "tony", false, 
				"Non je ne suis pas Ironman", 
				Situation.Salarie,  LocalDate.parse("1970-03-23"));
		locataire9 = locataireRepository.save(locataire9);
		Locataire locataire10 = new Locataire("julienperez", "Perez", "Julien", Civilite.Mr, "julienperez@mail.com",
				"0202020202", "julienperez", false, "Description Julien Perez", Situation.Autre, LocalDate.parse("1954-05-22"));
		locataire10 = locataireRepository.save(locataire10);
		Locataire locataire11 = new Locataire("victoire", "Fournier", "Victoire", Civilite.Mme, "victoire@mail.com",
				"0303030303", "victoire", true, "Description Victoire Fournier", Situation.Salarie, LocalDate.parse("1990-12-09"));
		locataire11 = locataireRepository.save(locataire11);
		Locataire locataire12 = new Locataire("jacquelinejacquet", "Jacquet", "Jacqueline", Civilite.Mme, "jacqueline@mail.com",
				"0011000004", "jacquelinejacquet", true, "Description Jacqueline Jacquet", Situation.Retraite, LocalDate.parse("1967-05-22"));
		locataire12 = locataireRepository.save(locataire12);
		Locataire locataire13 = new Locataire("marion", "Lambert", "Marion", Civilite.Mme, "marion@mail.com",
				"0011000005", "marion", false, "Description Marion Lambert", Situation.Etudiant, LocalDate.parse("1996-02-10"));
		locataire13 = locataireRepository.save(locataire13);
		Locataire locataire14 = new Locataire("beber", "Simon", "Bertrand", Civilite.Mr, "beber@mail.com",
				"0011000006", "beber", true, "Description Bertrand Simon", Situation.Etudiant, LocalDate.parse("1998-09-03"));
		locataire14 = locataireRepository.save(locataire14);
		Locataire locataire15 = new Locataire("sylvain", "Moreau", "Sylvain", Civilite.Mr, "sylvain@mail.com",
				"0011000007", "sylvain", true, "Description Sylvain Moreau", Situation.Salarie, LocalDate.parse("1980-11-14"));
		locataire15 = locataireRepository.save(locataire15);
		Locataire locataire16 = new Locataire("laura", "Faure", "Laura", Civilite.NB, "laura@mail.com",
				"0011000008", "laura", true, "Description Laura Faure", Situation.Salarie, LocalDate.parse("1990-01-01"));
		locataire16 = locataireRepository.save(locataire16);

		// Creation des Localisation
		Localisation locLog1 = new Localisation("New York", "West Village", "10014", "Bedford Street", 90);
		Localisation locLog2 = new Localisation("75", "Paris", "75001", "rue de la Paix", 2);
		Localisation locLog3 = new Localisation("75", "Paris", "75008", "rue de Montmartre", 7);
		Localisation locLog4 = new Localisation("75", "Paris", "75003", "avenue des Champs-Elysées", 20);

		// Creation des Logement
		Logement log1 = new Logement(proprietaire1, "Grand appart central à New York", "Beaucoup trop grand pour le prix et très bien agencé", 104, 2, 2, 1, 400.0, 50.0, 300.0, locLog1,
				TypeLogement.Appartement, LocalDate.parse("2021-11-14"), false);
		log1 = logementRepository.save(log1);
		Logement log2 = new Logement(proprietaire2,"Petit studio très bien placé", "Hyper cher mais bien placé", 40, 1, 0, 1, 3500.0, 50.0, 350.0, locLog2,
				TypeLogement.Studio, LocalDate.parse("2021-12-01"), true);
		log2 = logementRepository.save(log2);
		Logement log3 = new Logement(proprietaire3,"Maison charmante", "Maison hyper cosy dans Paris, proche des commerces", 110, 4, 0, 1, 500.0, 50.0, 275.0, locLog3,
				TypeLogement.Maison, LocalDate.parse("2021-11-24"), false);
		log3 = logementRepository.save(log3);
		Logement log4 = new Logement(proprietaire4,"Studio sur les Champs", "Trop de bruit la nuit", 35, 2, 0, 1, 3000.0, 50.0, 325.0, locLog4,
				TypeLogement.Studio, LocalDate.parse("2021-11-20"), true);
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
		Notation noteLoc1Lg1 = new Notation(log1, locataire1, 15.0, "Hyper cool");
		noteLoc1Lg1 = notationRepository.save(noteLoc1Lg1);
		Notation noteLoc2Lg1 = new Notation(log1, locataire2, 10.0, "Proprietaire pas sympa");
		noteLoc2Lg1 = notationRepository.save(noteLoc2Lg1);
		Notation noteLoc3Lg2 = new Notation(log2, locataire3, 3.0, "Le logement prend l'eau");
		noteLoc3Lg2 = notationRepository.save(noteLoc3Lg2);
		Notation noteLoc4Lg2 = new Notation(log2, locataire4, 15.0, "C'était top");
		noteLoc4Lg2 = notationRepository.save(noteLoc4Lg2);
		Notation noteLoc5Lg4 = new Notation(log4, locataire5, 18.0, "Super logement");
		noteLoc5Lg4 = notationRepository.save(noteLoc5Lg4);
		Notation noteLoc6Lg4 = new Notation(log4, locataire6, 10.0, "Passable pour quelque temps");
		noteLoc6Lg4 = notationRepository.save(noteLoc6Lg4);
		Notation noteLoc7Lg4 = new Notation(log4, locataire7, 11.0, "Logement trop loin du centre-ville");
		noteLoc7Lg4 = notationRepository.save(noteLoc7Lg4);
		Notation noteLoc8Lg4 = new Notation(log4, locataire8, 8.0, "Charges trop chères");
		noteLoc8Lg4 = notationRepository.save(noteLoc8Lg4);

		// Creation des Chambre
		Chambre ch1Log1 = new Chambre(log1, 12, "Chambre très lumineuse");
		ch1Log1 = chambreRepository.save(ch1Log1);
		Chambre ch2Log1 = new Chambre(log1, 13,  "Chambre spacieuse");
		ch2Log1 = chambreRepository.save(ch2Log1);
		Chambre ch1Log2 = new Chambre(log2, 15,  "Chambre très lumineuse");
		ch1Log2 = chambreRepository.save(ch1Log2);
		Chambre ch1Log3 = new Chambre(log3, 10, "Chambre très lumineuse");
		ch1Log3 = chambreRepository.save(ch1Log3);
		Chambre ch2Log3 = new Chambre(log3, 12, "Chambre spacieuse");
		ch2Log3 = chambreRepository.save(ch2Log3);
		Chambre ch3Log3 = new Chambre(log3, 14, "La plus grande des chambres du logement");
		ch3Log3 = chambreRepository.save(ch3Log3);
		Chambre ch4Log3 = new Chambre(log3, 13, "Orienté nord");
		ch4Log3 = chambreRepository.save(ch4Log3);
		Chambre ch1Log4 = new Chambre(log4, 12, "Chambre très lumineuse");
		ch1Log4 = chambreRepository.save(ch1Log4);
		Chambre ch2Log4 = new Chambre(log4, 16, "Chambre spacieuse");
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
		
		// Creation des Proprios
		Proprietaire proprietaire9 = new Proprietaire("alexandreb", "Bertrand", "Alexandre", Civilite.Mr,
				"alexandre.bertrand@mail.com", "0695178452", "1234");
		proprietaire9 = proprietaireRepository.save(proprietaire9);
		Proprietaire proprietaire10 = new Proprietaire("charlotted", "Durand", "Charlotte", Civilite.Mme,
				"charlotte.durand@mail.com", "0658523695", "1234");
		proprietaire10 = proprietaireRepository.save(proprietaire10);
		Proprietaire proprietaire11 = new Proprietaire("gregorym", "Michel", "Gregory", Civilite.Mr,
				"gregory.michel@mail.com", "0658412658", "1234");
		proprietaire11 = proprietaireRepository.save(proprietaire11);

		// Creation des Localisations
		Localisation locLog5 = new Localisation("44", "Nantes", "44000", "Rue Racine", 20);
		Localisation locLog6 = new Localisation("44", "Nantes", "44000", "Rue du Calvaire", 25);
		Localisation locLog7 = new Localisation("44", "Nantes", "44000", "Rue Bertrand Geslin", 13);
		Localisation locLog8 = new Localisation("44", "Nantes", "44100", "Rue Dobree", 2);

		// Creation des Logements
		Logement log5 = new Logement(proprietaire9, "Appartement plein centre ville",
				"Appartement pour 2 personnes. Situé rue Racine, animée et proche toute commodités", 70, 2, 0, 1, 300.0,
				35.0, 300.0, locLog5,
				TypeLogement.Appartement, LocalDate.now(), false);
		log5 = logementRepository.save(log5);
		Logement log6 = new Logement(proprietaire9, "Appartement rénové idéal coloc",
				"Appartement recemment rénové avec 3 chambres, dédié et pensé pour la colocation !", 80, 3, 0, 1, 400.0,
				40.0, 400.0, locLog6,
				TypeLogement.Appartement, LocalDate.now(), true);
		log6 = logementRepository.save(log6);
		Logement log7 = new Logement(proprietaire10, "Maison spacieuse",
				"Grande maison avec 4 chambres et 2 salles de bain pour la colocation. Très lumineux et entièrement équipé !",
				150, 4, 0, 2, 500.0, 25.0, 500.0, locLog7,
				TypeLogement.Maison, LocalDate.now(), true);
		log7 = logementRepository.save(log7);
		Logement log8 = new Logement(proprietaire11, "Appartement proche centre ville",
				"Appartement pour colocation à rue Dobree. 2 chambres de disponibles.", 65, 2, 0, 1, 425.0, 45.0, 425.0,
				locLog8,
				TypeLogement.Appartement, LocalDate.now(), true);
		log8 = logementRepository.save(log8);

			
				// Creation des Chambres
				Chambre ch1Log5 = new Chambre(log5, 12, "super sympa mais pas très grande");
				ch1Log5 = chambreRepository.save(ch1Log5);
				Chambre ch2Log5 = new Chambre(log5, 13, "Donne sur cours c'est ouf y'a des canards");
				ch2Log5 = chambreRepository.save(ch2Log5);
				
				Chambre ch1Log6 = new Chambre(log6, 15, "On entends les voitures mais y'a un bureau déjà c'est pas mal");
				ch1Log6 = chambreRepository.save(ch1Log6);
				Chambre ch2Log6 = new Chambre(log6, 15, "Joli tapis, mais on entends la chasse d'eau des toilettes");
				ch2Log6 = chambreRepository.save(ch2Log6);
				Chambre ch3Log6 = new Chambre(log6, 15, "l'ancien locataire a laissé des fringues mais ils sont jolis donc ça va");
				ch3Log6 = chambreRepository.save(ch3Log6);
				
				Chambre ch1Log7 = new Chambre(log7, 10, "Un peu petite mais la plus isolée, on entends rien");
				ch1Log7 = chambreRepository.save(ch1Log7);
				Chambre ch2Log7 = new Chambre(log7, 12, "Y'a une petite odeur, mais c'est tranquille");
				ch2Log7 = chambreRepository.save(ch2Log7);
				Chambre ch3Log7 = new Chambre(log7, 14, "parfaite pour un couple");
				ch3Log7 = chambreRepository.save(ch3Log7);
				Chambre ch4Log7 = new Chambre(log7, 13, "Chambre à côté du couple, franchement c'est bof");
				ch4Log7 = chambreRepository.save(ch4Log7);
				
				Chambre ch1Log8 = new Chambre(log8, 12, "La chambre est présente");
				ch1Log8 = chambreRepository.save(ch1Log8);
				Chambre ch2Log8 = new Chambre(log8, 16, "Le lit possède un matelas c'est pratique");
				ch2Log8 = chambreRepository.save(ch2Log8);


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
				
				Locataire locataire1log5 = new Locataire("monica", "Geller", "Monica", Civilite.Mme, "monicageller@mail.com",
						"0101010101", "monica", false, 
						"Maniaque mais veut absolument organiser toutes les soirées chez elle. Cuisine hyper bien et nourrit tout le monde", 
						Situation.Salarie,  LocalDate.parse("1969-03-09"));
				locataire1log5 = locataireRepository.save(locataire1log5);
				locataire1log5.setChambre(ch2Log5);
				Locataire locataire1log6 = new Locataire("anaisb", "Bruno", "Anais", Civilite.Mme, "anaisb@mail.com",
						"0202020202", "anaisb", false, "Aussi belle qu'une princesse Disney", Situation.Salarie, LocalDate.parse("1992-05-05"));
				locataire1log6 = locataireRepository.save(locataire1log6);
				locataire1log6.setChambre(ch1Log6);
				Locataire locataire2log6 = new Locataire("justinec", "Champagne", "Justine", Civilite.Mme, "justinec@mail.com",
						"0303030303", "justinec", false, "Travaille à toute heure du jour ou de la nuit. CHAT TROP CHOUPI", Situation.Salarie, LocalDate.parse("1993-02-09"));
				locataire2log6 = locataireRepository.save(locataire2log6);
				locataire2log6.setChambre(ch2Log6);
				Locataire locataire1log7 = new Locataire("emmaf", "Faurie", "Emma", Civilite.Mme, "emmaf@mail.com",
						"0011000004", "emmaf", false, "Utilise beaucoup le mot 'fichtre' et fait des randonnées dans la neige", Situation.Retraite, LocalDate.parse("1995-09-13"));
				locataire1log7 = locataireRepository.save(locataire1log7);
				locataire1log7.setChambre(ch1Log7);
				Locataire locataire2log7 = new Locataire("guillaumen", "Nguyen", "Guillaume", Civilite.Mr, "guillaumen@mail.com",
						"0011000005", "guillaumen", false, "Il a pas voulu venir à l'ile de ré avec nous on est très déçus", Situation.Etudiant, LocalDate.parse("1995-02-09"));
				locataire2log7 = locataireRepository.save(locataire2log7);
				locataire2log7.setChambre(ch3Log7);
				Locataire locataire1log8 = new Locataire("danielb", "Bilal", "Daniel", Civilite.Mr, "danielb@mail.com",
						"0011000006", "danielb", true, "Apprécie de manière démesurée les voitures", Situation.Etudiant, LocalDate.parse("1997-02-09"));
				locataire1log8 = locataireRepository.save(locataire1log8);
				locataire1log8.setChambre(ch1Log8);
				
				
	// MARSEILLE 
				
				// Creation des Proprios
				Proprietaire proprietaireMarseille1 = new Proprietaire("louised", "Desroches", "Louise", Civilite.Mme,
						"louised@mail.com", "0458972567", "1234");
				proprietaireMarseille1 = proprietaireRepository.save(proprietaireMarseille1);
				Proprietaire proprietaireMarseille2 = new Proprietaire("gabrielp", "Poulin", "Gabriel", Civilite.Mme,
						"gabrielp@mail.com", "05957582", "1234");
				proprietaireMarseille2 = proprietaireRepository.save(proprietaireMarseille2);
				Proprietaire proprietaireMarseille3 = new Proprietaire("felicienc", "Cloutier", "Felicien", Civilite.Mr,
						"felicienc@mail.com", "0695851475", "1234");
				proprietaireMarseille3 = proprietaireRepository.save(proprietaireMarseille3);
				Proprietaire proprietaireMarseille4 = new Proprietaire("agnesa", "Arcouet", "Agnes", Civilite.Mme,
						"agnesa@mail.com", "0695175825", "1234");
				proprietaireMarseille4 = proprietaireRepository.save(proprietaireMarseille4);

				// Creation des Locataires
				Locataire locataireMarseille1 = new Locataire("francish", "Hachee", "Francis", Civilite.Mr, "francish@mail.com",
						"0428672527", "1234", false, 
						"Maniaque mais veut absolument organiser toutes les soirées chez elle. Cuisine hyper bien et nourrit tout le monde", 
						Situation.Salarie,  LocalDate.parse("1969-03-09"));
				locataireMarseille1 = locataireRepository.save(locataireMarseille1);
				
				Locataire locataireMarseille2 = new Locataire("pierrer", "Rondin", "Pierre", Civilite.Mr, "pierrer@mail.com",
						"0658957414", "1234", false, "Bordélique et enfant gâtée mais peut t'habiller comme personne", Situation.Autre, LocalDate.parse("1969-05-05"));
				locataireMarseille2 = locataireRepository.save(locataireMarseille2);
				
				Locataire locataireMarseille3 = new Locataire("byronb", "Brisebois", "Byron", Civilite.Mr, "byronb@mail.com",
						"06359517", "1234", false, "Peut hypnotiser le propriétaire pour avoir un appartement. C'est aussi bizarre qu'il ait les réfs de tous les jeux vidéos du monde nan ?", Situation.Salarie, LocalDate.parse("1992-02-09"));
				locataireMarseille3 = locataireRepository.save(locataireMarseille3);
				
				Locataire locataireMarseille4 = new Locataire("arletteg", "Grondin", "Arlette", Civilite.Mme, "arletteg@mail.com",
						"0535952417", "1234", false, "Maniaque mais veut absolument organiser toutes les soirées chez elle. Cuisine hyper bien et nourrit tout le monde", Situation.Retraite, LocalDate.parse("1992-02-09"));
				locataireMarseille4 = locataireRepository.save(locataireMarseille4);
				
				Locataire locataireMarseille5 = new Locataire("daveta", "Adler", "Davet", Civilite.Mr, "daveta@mail.com",
						"0635712574", "1234", false, "Bordélique et enfant gâtée mais peut t'habiller comme personne", Situation.Etudiant, LocalDate.parse("1999-05-09"));
				locataireMarseille5 = locataireRepository.save(locataireMarseille5);
				
				Locataire locataireMarseille6 = new Locataire("delmara", "Aubin", "Delmar", Civilite.Mr, "delmara@mail.com",
						"0635257489", "1234", false, "Peut hypnotiser le propriétaire pour avoir un appartement.", Situation.Etudiant, LocalDate.parse("1998-02-15"));
				locataireMarseille6 = locataireRepository.save(locataireMarseille6);
				
				

				// Creation des Localisations
				Localisation locLogMarseille1 = new Localisation("Bouches-du-Rhone", "Marseille", "13013", "boulevard de la Liberation", 61);
				Localisation locLogMarseille2 = new Localisation("Bouches-du-Rhone", "Marseille", "13008", "cours Franklin Roosevelt", 29);
				Localisation locLogMarseille3 = new Localisation("Bouches-du-Rhone", "Marseille", "13014", "boulevard de la Liberation", 50);
				Localisation locLogMarseille4 = new Localisation("Bouches-du-Rhone", "Marseille", "13008", "cours Franklin Roosevelt", 83);
				Localisation locLogMarseille5 = new Localisation("Bouches-du-Rhone", "Marseille", "13014", "boulevard de la Liberation", 32);
				Localisation locLogMarseille6 = new Localisation("Bouches-du-Rhone", "Marseille", "13002", "rue Beauvau", 137);

				// Creation des Logements
				Logement logMarseille1 = new Logement(proprietaireMarseille1, "Grand appart central", "Beaucoup trop grand pour le prix et très bien agencé", 104, 2, 2, 1, 180.0, 50.0, 300.0, locLogMarseille1,
						TypeLogement.Appartement, LocalDate.now(), false);
				logMarseille1 = logementRepository.save(logMarseille1);
				
				Logement logMarseille2 = new Logement(proprietaireMarseille1,"Appartement pour 2 en colocation", "Bel appartement pour colocation" , 65, 2, 2, 1, 500.0, 50.0, 350.0, locLogMarseille2,
						TypeLogement.Appartement, LocalDate.now(), true);
				logMarseille2 = logementRepository.save(logMarseille2);
				
				Logement logMarseille3 = new Logement(proprietaireMarseille2,"Appartement exceptionnel centre ville", "En plein coeur du centre ville, proche toutes commoditées" , 110, 3, 2, 1, 375.0, 50.0, 375.0, locLogMarseille3,
						TypeLogement.Appartement, LocalDate.now(), false);
				logMarseille3 = logementRepository.save(logMarseille3);
				
				Logement logMarseille4 = new Logement(proprietaireMarseille2,"Maison recemment rénové pour 3", "Recemment renové et penser pour la vie en colocation. Dispose de 3 chambre et 1 salle de bain", 120, 3, 0, 1, 325.0, 50.0, 325.0, locLogMarseille4,
						TypeLogement.Maison, LocalDate.now(), true);
				logMarseille4 = logementRepository.save(logMarseille4);
				
				Logement logMarseille5 = new Logement(proprietaireMarseille3,"Maison avec emplacement exceptionnel", "Maison en colocation. Très bien placé, entièrement équipé", 110, 3, 0, 2, 600.0, 50.0, 600.0, locLogMarseille5,
						TypeLogement.Maison, LocalDate.now(), true);
				logMarseille5 = logementRepository.save(logMarseille5);
				
				Logement logMarseille6 = new Logement(proprietaireMarseille4,"Appartement pour 2 colocataire", "Très bel appartement avec 2 chambres, 1 salle de bain et grande pièce de vie" , 70, 2, 0, 1, 420.0, 50.0, 420.0, locLogMarseille6,
						TypeLogement.Appartement, LocalDate.now(), true);
				logMarseille6 = logementRepository.save(logMarseille6);
				
				
				
				
				
		
				// Creation des Chambre
				Chambre ch1Log1Marseille = new Chambre(logMarseille1, 12, "");
				ch1Log1Marseille = chambreRepository.save(ch1Log1Marseille);
				Chambre ch2Log1Marseille = new Chambre(logMarseille1, 13,  "");
				ch2Log1Marseille = chambreRepository.save(ch2Log1Marseille);
				
				Chambre ch1Log2Marseille = new Chambre(logMarseille3, 12, "");
				ch1Log2Marseille = chambreRepository.save(ch1Log2Marseille);
				Chambre ch2Log2Marseille = new Chambre(logMarseille3, 13,  "");
				ch2Log2Marseille = chambreRepository.save(ch2Log2Marseille);
				
				Chambre ch1Log3Marseille = new Chambre(logMarseille3, 12, "");
				ch1Log2Marseille = chambreRepository.save(ch1Log3Marseille);
				Chambre ch2Log3Marseille = new Chambre(logMarseille3, 13,  "");
				ch2Log2Marseille = chambreRepository.save(ch2Log3Marseille);
				Chambre ch3Log3Marseille = new Chambre(logMarseille3, 13,  "");
				ch3Log3Marseille = chambreRepository.save(ch3Log3Marseille);
				
				Chambre ch1Log4Marseille = new Chambre(logMarseille3, 12, "");
				ch1Log4Marseille = chambreRepository.save(ch1Log4Marseille);
				Chambre ch2Log4Marseille = new Chambre(logMarseille3, 13,  "");
				ch2Log4Marseille = chambreRepository.save(ch2Log4Marseille);
				Chambre ch3Log4Marseille = new Chambre(logMarseille3, 13,  "");
				ch3Log4Marseille = chambreRepository.save(ch3Log4Marseille);
				
				Chambre ch1Log5Marseille = new Chambre(logMarseille5, 12, "");
				ch1Log5Marseille = chambreRepository.save(ch1Log5Marseille);
				Chambre ch2Log5Marseille = new Chambre(logMarseille5, 13,  "");
				ch2Log5Marseille = chambreRepository.save(ch2Log5Marseille);
				Chambre ch3Log5Marseille = new Chambre(logMarseille5, 13,  "");
				ch3Log5Marseille = chambreRepository.save(ch3Log5Marseille);
				
				Chambre ch1Log6Marseille = new Chambre(logMarseille6, 12, "");
				ch1Log6Marseille = chambreRepository.save(ch1Log6Marseille);
				Chambre ch2Log6Marseille = new Chambre(logMarseille6, 13,  "");
				ch2Log6Marseille = chambreRepository.save(ch2Log6Marseille);
				
				
		
		// LYON
	
		// Creation des Localisation
		Localisation locLogLyon1 = new Localisation("69", "Lyon", "69007", "Rue De Marseille", 38);
		Localisation locLogLyon3 = new Localisation("69", "Lyon", "69005", "Rue Pierre Marion", 8);
		Localisation locLogLyon2 = new Localisation("69", "Lyon", "69001", "Place De La Comédie", 1);
		Localisation locLogLyon4 = new Localisation("69", "Lyon", "69003", "Rue Moncey", 95);

		// Creation des Logement
		Logement log1Lyon = new Logement(proprietaire4, "Appartement plein centre ville", "Appartement pour 2 personnes. Situé rue de Marseille, animée et proche toute commodités", 70, 2, 0, 1, 300.0, 35.0, 300.0, locLogLyon1, TypeLogement.Appartement, LocalDate.parse("2021-11-03"), false);
		log1Lyon = logementRepository.save(log1Lyon);
		
		Logement log2Lyon = new Logement(proprietaire4, "Appartement rénové idéal coloc", "Appartement recemment rénové avec 3 chambres, dédié et pensé pour la colocation !", 40, 3, 0, 1, 400.0, 80.0, 400.0, locLogLyon2,TypeLogement.Appartement, LocalDate.parse("2021-11-20"), true);
		log2Lyon = logementRepository.save(log2Lyon);

		Logement log3Lyon = new Logement(proprietaire5, "Maison très lumineuse","Grande maison avec 4 chambres et 2 salles de bain pour la colocation. Très lumineux et entièrement équipé !", 150, 4, 0, 2, 500.0, 25.0, 500.0, locLogLyon3,TypeLogement.Maison, LocalDate.parse("2021-12-03"), true);
		log3Lyon = logementRepository.save(log3Lyon);
		
		Logement log4Lyon = new Logement(proprietaire5, "Appartement proche centre ville",
		"Appartement pour colocation à rue Moncey. 2 chambres de disponibles.", 65, 2, 0, 1, 425.0, 45.0, 425.0,
		locLogLyon4,
		TypeLogement.Appartement, LocalDate.parse("2021-11-24"), true);
		log4Lyon = logementRepository.save(log4Lyon);

		Chambre lyonCh1Log1 = new Chambre(log1Lyon, 12);
		lyonCh1Log1 = chambreRepository.save(lyonCh1Log1);
		// Creation des Chambre
		Chambre lyonCh2Log1 = new Chambre(log1Lyon, 13);
		lyonCh2Log1 = chambreRepository.save(lyonCh2Log1);

		Chambre lyonCh1Log2 = new Chambre(log2Lyon, 15);
		lyonCh1Log2 = chambreRepository.save(lyonCh1Log2);
		Chambre lyonCh2Log2 = new Chambre(log2Lyon, 15);
		lyonCh2Log2 = chambreRepository.save(lyonCh2Log2);
		Chambre lyonCh3Log2 = new Chambre(log2Lyon, 15);
		lyonCh3Log2 = chambreRepository.save(lyonCh3Log2);

		Chambre lyonCh1Log3 = new Chambre(log3Lyon, 10);
		lyonCh1Log3 = chambreRepository.save(lyonCh1Log3);
		Chambre lyonCh2Log3 = new Chambre(log3Lyon, 12);
		lyonCh2Log3 = chambreRepository.save(lyonCh2Log3);
		Chambre lyonCh3Log3 = new Chambre(log3Lyon, 14);
		lyonCh3Log3 = chambreRepository.save(lyonCh3Log3);
		Chambre lyonCh4Log3 = new Chambre(log3Lyon, 13);
		lyonCh4Log3 = chambreRepository.save(lyonCh4Log3);

		Chambre lyonCh1Log4 = new Chambre(log4Lyon, 12);
		lyonCh1Log4 = chambreRepository.save(lyonCh1Log4);
		Chambre lyonCh2Log4 = new Chambre(log4Lyon, 16);
		lyonCh2Log4 = chambreRepository.save(lyonCh2Log4);

		// Ajout de Commodite a Logement
		log1Lyon.addCommodite(balcon);
		log1Lyon.addCommodite(parking);
		log1Lyon.addCommodite(fibre);
		log1Lyon = logementRepository.save(log1Lyon);
		log2Lyon.addCommodite(handicape);
		log2Lyon.addCommodite(parking);
		log2Lyon = logementRepository.save(log2Lyon);
		log3Lyon.addCommodite(jardin);
		log3Lyon.addCommodite(parking);
		log3Lyon.addCommodite(fibre);
		log3Lyon = logementRepository.save(log3Lyon);
		log4Lyon.addCommodite(fibre);
		log4Lyon.addCommodite(balcon);
		log4Lyon.addCommodite(salleDeSport);
		log4Lyon.addCommodite(handicape);
		// Ajout de Regle a Logement

		log4Lyon = logementRepository.save(log4Lyon);
		log1Lyon.addRegle(fumeurAutorise);
		log2Lyon.addRegle(animauxAutorises);
		log1Lyon = logementRepository.save(log1Lyon);
		log2Lyon = logementRepository.save(log2Lyon);
		log3Lyon.addRegle(animauxAutorises);
		log3Lyon.addRegle(passSanitaire);
		log3Lyon = logementRepository.save(log3Lyon);
		log4Lyon.addRegle(femmeUniquement);

		// Ajout Photos
		log4Lyon = logementRepository.save(log4Lyon);
		Photo lyonPhoto1Log1 = new Photo("lyonPhoto1Log1", "logement2_1.png", 1, log1Lyon);
		lyonPhoto1Log1 = photoRepository.save(lyonPhoto1Log1);
		Photo lyonPhoto2Log1 = new Photo("lyonPhoto2Log1", "logement2_2.png", 2, log1Lyon);
		lyonPhoto2Log1 = photoRepository.save(lyonPhoto2Log1);
		Photo lyonPhoto3Log1 = new Photo("lyonPhoto3Log1", "logement2_3.jpg", 3, log1Lyon);
		lyonPhoto3Log1 = photoRepository.save(lyonPhoto3Log1);
		Photo lyonPhoto1Log2 = new Photo("lyonPhoto1Log2", "logement2_4.jpg", 4, log2Lyon);
		lyonPhoto1Log2 = photoRepository.save(lyonPhoto1Log2);
		Photo lyonPhoto2Log2 = new Photo("lyonPhoto2Log2", "logement3_1.png", 1, log2Lyon);
		lyonPhoto2Log2 = photoRepository.save(lyonPhoto2Log2);
		Photo lyonPhoto3Log2 = new Photo("lyonPhoto3Log2", "logement3_2.png", 2, log2Lyon);
		lyonPhoto3Log2 = photoRepository.save(lyonPhoto3Log2);
		Photo lyonPhoto1Log3 = new Photo("lyonPhoto1Log3", "logement3_3.jpg", 3, log3Lyon);
		lyonPhoto1Log3 = photoRepository.save(lyonPhoto1Log3);
		Photo lyonPhoto2Log3 = new Photo("lyonPhoto2Log3", "logement3_4.jpg", 4, log3Lyon);
		lyonPhoto2Log3 = photoRepository.save(lyonPhoto2Log3);
		Photo lyonPhoto3Log3 = new Photo("lyonPhoto3Log3", "logement4_1.jpg", 1, log3Lyon);
		lyonPhoto3Log3 = photoRepository.save(lyonPhoto3Log3);
		Photo lyonPhoto1Log4 = new Photo("lyonPhoto1Log4", "logement4_2.jpg", 2, log4Lyon);
		lyonPhoto1Log4 = photoRepository.save(lyonPhoto1Log4);
		Photo lyonPhoto2Log4 = new Photo("lyonPhoto2Log4", "logement4_3.jpg", 3, log4Lyon);
		lyonPhoto2Log4 = photoRepository.save(lyonPhoto2Log4);
		Photo lyonPhoto3Log4 = new Photo("lyonPhoto3Log4", "logement4_4.png", 4, log4Lyon);
		lyonPhoto3Log4 = photoRepository.save(lyonPhoto3Log4);
				
				// Creation des Dossiers
				Dossier dossierLocMarseille1 = new Dossier(1500.0, 2200.0, Situation.Salarie);
				locataireMarseille1.setDossier(dossierLocMarseille1);
				locataireMarseille1 = locataireRepository.save(locataireMarseille1);
				Dossier dossierLocMarseille2 = new Dossier(1500.0, 2200.0, Situation.Retraite);
				locataireMarseille2.setDossier(dossierLocMarseille2);
				locataireMarseille2 = locataireRepository.save(locataireMarseille2);
				Dossier dossierLocMarseille3 = new Dossier(0.0, 2500.0, Situation.Salarie);
				locataireMarseille3.setDossier(dossierLocMarseille3);
				locataireMarseille3 = locataireRepository.save(locataireMarseille3);
				Dossier dossierLocMarseille4 = new Dossier(800.0, 1600.0, Situation.Salarie);
				locataireMarseille4.setDossier(dossierLocMarseille4);
				locataireMarseille4 = locataireRepository.save(locataireMarseille4);
				Dossier dossierLocMarseille5 = new Dossier(1200.0, 1600.0, Situation.Salarie);
				locataireMarseille5.setDossier(dossierLocMarseille5);
				locataireMarseille5 = locataireRepository.save(locataireMarseille5);
				Dossier dossierLocMarseille6 = new Dossier(1200.0, 1600.0, Situation.Salarie);
				locataireMarseille6.setDossier(dossierLocMarseille6);
				locataireMarseille6 = locataireRepository.save(locataireMarseille6);
				
				
				
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
				log5.addCommodite(balcon);
				log5.addCommodite(parking);
				log5.addCommodite(fibre);
				log5 = logementRepository.save(log5);
				log6.addCommodite(jardin);
				log6.addCommodite(parking);
				log6.addCommodite(fibre);
				log6 = logementRepository.save(log6);

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
				log5.addRegle(fumeurAutorise);
				log5 = logementRepository.save(log5);
				log6.addRegle(animauxAutorises);
				log6.addRegle(passSanitaire);
				log6 = logementRepository.save(log6);
	}

}
