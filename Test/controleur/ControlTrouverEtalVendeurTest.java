package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlAcheterProduit controlAcheterProduit;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Vendeur1", 1);
		controlEmmenager.ajouterGaulois("Vendeur2", 1);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlPrendreEtal.prendreEtal("Vendeur1", "Banane", 10);
		controlPrendreEtal.prendreEtal("Vendeur2", "Banane", 10);
	}
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Intru"));
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Vendeur1"));
	}

}
