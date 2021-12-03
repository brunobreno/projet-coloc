package coloc.back;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import coloc.back.model.Chambre;
import coloc.back.model.Civilite;
import coloc.back.model.Commodite;
import coloc.back.model.Dossier;
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
import coloc.back.repository.ILocataireRepository;
import coloc.back.repository.ILogementRepository;
import coloc.back.repository.IMessageRepository;
import coloc.back.repository.INotationRepository;
import coloc.back.repository.IPhotoRepository;
import coloc.back.repository.IProprietaireRepository;
import coloc.back.repository.IRegleRepository;
import coloc.back.repository.IUtilisateurRepository;

@SpringBootTest
class ProjetColocBackApplicationTests {

	@Autowired
	private IUtilisateurRepository utilisateurRepository;
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
	
	String Lorem ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse lectus tortor, dignissim sit amet, ";

			
	@Test
	void contextLoads() {
		// Creation des Proprio
		Proprietaire proprietaire1 = new Proprietaire("NomProprietaire1", "PrenomProprietaire1", Civilite.Mr,
				"proprietaire1@mail.com", "0000000001", "proprietaire1");
		proprietaire1 = proprietaireRepository.save(proprietaire1);
		Proprietaire proprietaire2 = new Proprietaire("NomProprietaire2", "PrenomProprietaire2", Civilite.Mme,
				"proprietaire2@mail.com", "0000000002", "proprietaire2");
		proprietaire2 = proprietaireRepository.save(proprietaire2);
		Proprietaire proprietaire3 = new Proprietaire("NomProprietaire3", "PrenomProprietaire3", Civilite.Mr,
				"proprietaire3@mail.com", "0000000003", "proprietaire3");
		proprietaire3 = proprietaireRepository.save(proprietaire3);
		Proprietaire proprietaire4 = new Proprietaire("NomProprietaire4", "PrenomProprietaire4", Civilite.Mme,
				"proprietaire4@mail.com", "0000000004", "proprietaire4");
		proprietaire4 = proprietaireRepository.save(proprietaire4);

		// Creation des Locataire
		Locataire locataire1 = new Locataire("NomLocataire1", "PrenomLocataire1", Civilite.Mr, "locataire1@mail.com",
				"0011000001", "locataire1", true, 
				"Description locataire 1" + Lorem, 
				Situation.Etudiant);
		locataire1 = locataireRepository.save(locataire1);
		Locataire locataire2 = new Locataire("NomLocataire2", "PrenomLocataire2", Civilite.Mr, "locataire2@mail.com",
				"0011000002", "locataire2", true, "Description locataire 2" + Lorem , Situation.Salarie);
		locataire2 = locataireRepository.save(locataire2);
		Locataire locataire3 = new Locataire("NomLocataire3", "PrenomLocataire3", Civilite.Mme, "locataire3@mail.com",
				"0011000003", "locataire3", true, "Description locataire 3" + Lorem, Situation.Etudiant);
		locataire3 = locataireRepository.save(locataire3);
		Locataire locataire4 = new Locataire("NomLocataire4", "PrenomLocataire4", Civilite.Mr, "locataire4@mail.com",
				"0011000004", "locataire4", false, "Description locataire 4" + Lorem, Situation.Retraite);
		locataire4 = locataireRepository.save(locataire4);
		Locataire locataire5 = new Locataire("NomLocataire5", "PrenomLocataire5", Civilite.Mme, "locataire5@mail.com",
				"0011000005", "locataire5", false, "Description locataire 5" + Lorem, Situation.Etudiant);
		locataire5 = locataireRepository.save(locataire5);
		Locataire locataire6 = new Locataire("NomLocataire6", "PrenomLocataire6", Civilite.Mme, "locataire6@mail.com",
				"0011000006", "locataire6", true, "Description locataire 6" + Lorem, Situation.Etudiant);
		locataire6 = locataireRepository.save(locataire6);
		Locataire locataire7 = new Locataire("NomLocataire7", "PrenomLocataire7", Civilite.Mr, "locataire7@mail.com",
				"0011000007", "locataire7", true, "Description locataire 7" + Lorem , Situation.Salarie);
		locataire7 = locataireRepository.save(locataire7);
		Locataire locataire8 = new Locataire("NomLocataire8", "PrenomLocataire8", Civilite.Mme, "locataire8@mail.com",
				"0011000008", "locataire8", true, "Description locataire 8" + Lorem, Situation.Salarie);
		locataire8 = locataireRepository.save(locataire8);

		// Creation des Localisation
		Localisation locLog1 = new Localisation("departementLog1", "villeLog1", "cpLog1", "voieLog1", 1);
		Localisation locLog2 = new Localisation("departementLog2", "villeLog2", "cpLog2", "voieLog2", 2);
		Localisation locLog3 = new Localisation("departementLog3", "villeLog3", "cpLog3", "voieLog3", 3);
		Localisation locLog4 = new Localisation("departementLog4", "villeLog4", "cpLog4", "voieLog4", 4);

		// Creation des Logement
		Logement log1 = new Logement(proprietaire1, "Description log1" + Lorem, 70, 2, 0, 1, 300.0, 50.0, 300.0, locLog1,
				TypeLogement.Appartement, LocalDate.now());
		log1 = logementRepository.save(log1);
		Logement log2 = new Logement(proprietaire2, "Description log2" + Lorem, 40, 1, 0, 1, 350.0, 50.0, 350.0, locLog2,
				TypeLogement.Studio, LocalDate.now());
		log2 = logementRepository.save(log2);
		Logement log3 = new Logement(proprietaire3, "Description log3" + Lorem, 110, 4, 0, 1, 275.0, 50.0, 275.0, locLog3,
				TypeLogement.Maison, LocalDate.now());
		log3 = logementRepository.save(log3);
		Logement log4 = new Logement(proprietaire4, "Description log4" + Lorem, 35, 2, 0, 1, 325.0, 50.0, 325.0, locLog4,
				TypeLogement.Studio, LocalDate.now());
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
		Commodite climatisation = new Commodite("climatisation",".climatisation.svg");
		climatisation = commoditeRepository.save(climatisation);
		Commodite television = new Commodite("television","television.svg");
		television = commoditeRepository.save(television);
		Commodite laveLinge = new Commodite("lave linge","lave-linge.svg");
		laveLinge = commoditeRepository.save(laveLinge);
		Commodite laveVaiselle = new Commodite("lave vaisselle","lave-vaiselle.svg");
		laveVaiselle = commoditeRepository.save(laveVaiselle);

		// Creation des Regle
		Regle fumeurAutorise = new Regle("fumeur autorise");
		fumeurAutorise = regleRepository.save(fumeurAutorise);
		Regle animauxAutorises = new Regle("animaux autorises");
		animauxAutorises = regleRepository.save(animauxAutorises);
		Regle femmeUniquement = new Regle("femme uniquement");
		femmeUniquement = regleRepository.save(femmeUniquement);
		Regle hommeUniquement = new Regle("homme uniquement");
		hommeUniquement = regleRepository.save(hommeUniquement);
		Regle passSanitaire = new Regle("pass sanitaire");
		passSanitaire = regleRepository.save(passSanitaire);

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
		Chambre ch1Log1 = new Chambre(log1, 12);
		ch1Log1 = chambreRepository.save(ch1Log1);
		Chambre ch2Log1 = new Chambre(log1, 13);
		ch2Log1 = chambreRepository.save(ch2Log1);
		Chambre ch1Log2 = new Chambre(log2, 15);
		ch1Log2 = chambreRepository.save(ch1Log2);
		Chambre ch1Log3 = new Chambre(log3, 10);
		ch1Log3 = chambreRepository.save(ch1Log3);
		Chambre ch2Log3 = new Chambre(log3, 12);
		ch2Log3 = chambreRepository.save(ch2Log3);
		Chambre ch3Log3 = new Chambre(log3, 14);
		ch3Log3 = chambreRepository.save(ch3Log3);
		Chambre ch4Log3 = new Chambre(log3, 13);
		ch4Log3 = chambreRepository.save(ch4Log3);
		Chambre ch1Log4 = new Chambre(log4, 12);
		ch1Log4 = chambreRepository.save(ch1Log4);
		Chambre ch2Log4 = new Chambre(log4, 16);
		ch2Log4 = chambreRepository.save(ch2Log4);

		// Creation des Message
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
		Photo photo1Log1 = new Photo("Photo1Log1", "URLPhoto1Log1", 1, log1);
		photo1Log1 = photoRepository.save(photo1Log1);
		Photo photo2Log1 = new Photo("Photo2Log1", "URLPhoto2Log1", 2, log1);
		photo2Log1 = photoRepository.save(photo2Log1);
		Photo photo3Log1 = new Photo("Photo3Log1", "URLPhoto3Log1", 3, log1);
		photo3Log1 = photoRepository.save(photo3Log1);
		Photo photo4Log1 = new Photo("Photo4Log1", "URLPhoto4Log1", 4, log1);
		photo4Log1 = photoRepository.save(photo4Log1);
		Photo photo1Log2 = new Photo("Photo1Log2", "URLPhoto1Log2", 1, log2);
		photo1Log2 = photoRepository.save(photo1Log2);
		Photo photo2Log2 = new Photo("Photo2Log2", "URLPhoto2Log2", 2, log2);
		photo2Log2 = photoRepository.save(photo2Log2);
		Photo photo3Log2 = new Photo("Photo3Log2", "URLPhoto3Log2", 3, log2);
		photo3Log2 = photoRepository.save(photo3Log2);
		Photo photo4Log2 = new Photo("Photo4Log2", "URLPhoto4Log2", 4, log2);
		photo4Log2 = photoRepository.save(photo4Log2);
		Photo photo1Log3 = new Photo("Photo1Log3", "URLPhoto1Log3", 1, log3);
		photo1Log3 = photoRepository.save(photo1Log3);
		Photo photo2Log3 = new Photo("Photo2Log3", "URLPhoto2Log3", 2, log3);
		photo2Log3 = photoRepository.save(photo2Log3);
		Photo photo3Log3 = new Photo("Photo3Log3", "URLPhoto3Log3", 3, log3);
		photo3Log3 = photoRepository.save(photo3Log3);
		Photo photo4Log3 = new Photo("Photo4Log3", "URLPhoto4Log3", 4, log3);
		photo4Log3 = photoRepository.save(photo4Log3);
		Photo photo1Log4 = new Photo("Photo1Log4", "URLPhoto1Log4", 1, log4);
		photo1Log4 = photoRepository.save(photo1Log4);
		Photo photo2Log4 = new Photo("Photo2Log4", "URLPhoto2Log4", 2, log4);
		photo2Log4 = photoRepository.save(photo2Log4);
		Photo photo3Log4 = new Photo("Photo3Log4", "URLPhoto3Log4", 3, log4);
		photo3Log4 = photoRepository.save(photo3Log4);
		Photo photo4Log4 = new Photo("Photo4Log4", "URLPhoto4Log4", 4, log4);
		photo4Log4 = photoRepository.save(photo4Log4);
	}

}
