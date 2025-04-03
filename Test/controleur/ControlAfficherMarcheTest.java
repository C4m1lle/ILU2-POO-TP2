package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private ControlAfficherMarche controlAfficherMarche;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Abraracourcix", "banane", 15);
	}
	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche,"Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerInfosMarche() {
		assertEquals(controlAfficherMarche.donnerInfosMarche()[0],"Abraracourcix");
		assertEquals(controlAfficherMarche.donnerInfosMarche()[1],"15");
		assertEquals(controlAfficherMarche.donnerInfosMarche()[2],"banane");
	}

}
