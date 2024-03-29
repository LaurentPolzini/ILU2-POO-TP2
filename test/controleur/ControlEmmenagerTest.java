package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {

	ControlEmmenager control;
	
	@BeforeEach
	void setUp() throws Exception {
		Village village = new Village("Village des gaugau", 5, 5);
		Chef chef = new Chef("Toto", 15, village);
		village.setChef(chef);
		control = new ControlEmmenager(village);
	}

	@Test
	void testControlEmmenager() {
		assertTrue(control != null);
	}

	@Test
	void testAjouterTropGaulois() {
		control.ajouterGaulois("Asterix", 10);
		control.ajouterGaulois("Panoramix", 10);
		control.ajouterGaulois("Gaulix", 10);
		control.ajouterGaulois("Fredix", 10);
		control.ajouterGaulois("Bilux", 10);
		control.ajouterGaulois("Astix", 10);
		control.ajouterDruide("Turlututu", 2, 10, 20);
		
		assertTrue(control.isHabitant("Asterix"));
		assertFalse(control.isHabitant("Obelix"));
		assertFalse(control.isHabitant("Astix"));
		assertFalse(control.isHabitant("gaulix"));
		assertFalse(control.isHabitant("Turtlututu"));
	}

	@Test
	void testAjouterDruide() {
		boolean levee = false;
		try {
			control.ajouterDruide(null, 1, 10, 15);
		} catch (NullPointerException e){
			levee = true;
		}
		assertTrue(levee);
	}


}
