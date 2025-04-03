package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;

	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlAfficherVillage controlAfficherVillage;
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		Chef abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);

		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("Abraracourcix", "banane", 15);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0],"Abraracourcix");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(),"le village des irréductibles");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(),5);
	}

}
