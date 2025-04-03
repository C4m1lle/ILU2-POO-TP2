package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
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
	}
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		assertEquals(controlPrendreEtal.resteEtals(),true);
		controlPrendreEtal.prendreEtal("Vendeur1", "Banane", 10);
		controlPrendreEtal.prendreEtal("Vendeur2", "Banane2", 10);
		assertEquals(controlPrendreEtal.resteEtals(),false);
	}

	@Test
	void testPrendreEtal() {
		assertEquals(controlAcheterProduit.vendeursProduit("banane"),null);
		controlPrendreEtal.prendreEtal("Vendeur1", "Banane", 10);
		assertEquals(controlAcheterProduit.vendeursProduit("Banane")[0],"Vendeur1");
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite("Vendeur1"));
		assertFalse(controlPrendreEtal.verifierIdentite("Pierre niney"));
	}

}
