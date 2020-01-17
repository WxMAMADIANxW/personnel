package testsUnitaires;

import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import personnel.Ligue;

class TestGestionPersonnel {

	@Test
	void testAddRemove() {
		SortedSet<Ligue> ligues = new TreeSet<>(); ;
		Ligue ligue = new Ligue("La LDC");
		ligues.add(ligue);
		assertTrue(ligues.contains(ligue));
		ligues.remove(ligue);
		assertFalse(ligues.contains(ligue));
		
	}


}
