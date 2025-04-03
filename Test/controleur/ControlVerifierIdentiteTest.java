package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;

	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}
	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Vira"));
	}

}
