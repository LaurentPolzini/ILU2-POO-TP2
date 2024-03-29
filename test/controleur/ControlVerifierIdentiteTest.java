package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des gaulios", 10, 5);
		Chef chef = new Chef("chef", 10, village);
		village.setChef(chef);
		this.controlVerifierIdentite = new ControlVerifierIdentite(village);
		
		village.ajouterHabitant(new Gaulois("Toto", 4));
	}

	@Test
	void testControlVerifierIdentite() {
		assertTrue(controlVerifierIdentite != null);
	}

	@Test
	void testVerifierIdentite() {
		assertTrue(controlVerifierIdentite.verifierIdentite("Toto"));
		
		boolean levee = false;
		try {
			controlVerifierIdentite.verifierIdentite(null);
		} catch (NullPointerException e) {
			levee = true;
		}
		assertTrue(levee);
	}

}
