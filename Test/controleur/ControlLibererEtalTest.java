package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	private ControlLibererEtal controlLibererEtal;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlEmmenager.ajouterGaulois("Vendeur1", 1);
		controlEmmenager.ajouterGaulois("Vendeur2", 1);
		controlPrendreEtal.prendreEtal("Vendeur1", "Banane", 10);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		assertTrue(controlLibererEtal.isVendeur("Vendeur1"));
		assertFalse(controlLibererEtal.isVendeur("Vendeur2"));
		assertFalse(controlLibererEtal.isVendeur("Intru"));
	}

	@Test
	void testLibererEtal() {
		assertTrue(controlLibererEtal.isVendeur("Vendeur1"));
		controlLibererEtal.libererEtal("Vendeur1");
		assertFalse(controlLibererEtal.isVendeur("Vendeur1"));
	}

}
