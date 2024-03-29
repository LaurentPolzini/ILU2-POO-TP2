package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	ControlPrendreEtal controlPrendreEtal;
	ControlVerifierIdentite controlVerifId;
	ControlLibererEtal controlLibEtal;
	ControlTrouverEtalVendeur controlTrouverVendeur;
	Village village;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Village des gaugau", 5, 2);
		Chef chef = new Chef("Toto", 15, village);
		village.setChef(chef);
		controlVerifId = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifId, village);
		controlTrouverVendeur = new ControlTrouverEtalVendeur(village);
		controlLibEtal = new ControlLibererEtal(controlTrouverVendeur);
	}

	@Test
	void testResteEtals() {
		controlPrendreEtal.prendreEtal("Glix", "fleurs", 15);
		assertTrue(controlPrendreEtal.resteEtals());
		
		controlPrendreEtal.prendreEtal("Glux, frere de Glix", "weed", 10);
		assertFalse(controlPrendreEtal.resteEtals());
		
		controlLibEtal.libererEtal("Glix");
		assertTrue(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

	@Test
	void testIsVendeur() {
		fail("Not yet implemented");
	}

	@Test
	void testIsOccupe() {
		fail("Not yet implemented");
	}

}
