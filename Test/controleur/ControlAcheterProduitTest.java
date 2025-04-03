package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Abraracourcix", "banane", 15);
		
	}
	
	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit,"Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		assertFalse(controlAcheterProduit.verifierIdentite("Asterix"));
		Gaulois asterix = new Gaulois("Asterix",5);
		village.ajouterHabitant(asterix);
		assertTrue(controlAcheterProduit.verifierIdentite("Asterix"));
	}

	@Test
	void testVendeursProduit() {
		assertNull(controlAcheterProduit.vendeursProduit(null));
		assertEquals(controlAcheterProduit.vendeursProduit("porte-avion"),null);
		assertEquals(controlAcheterProduit.vendeursProduit("banane")[0],"Abraracourcix");
	}

	@Test
	void testGetQuantiteProduit() {
		assertEquals(controlAcheterProduit.getQuantiteProduit("Abraracourcix"), 15);
	}

	@Test
	void testAcheterProduit() {
		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 10),10);
		assertEquals(controlAcheterProduit.acheterProduit("Abraracourcix", 10),5);
	}

}
