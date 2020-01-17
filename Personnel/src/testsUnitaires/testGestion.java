package testsUnitaires;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;

import org.junit.jupiter.api.Test;

import personnel.Employe;
import personnel.Ligue;

class testGestion {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	
	void testAdd() 
	{
		SortedSet<Ligue> ligues = null;
		Ligue ligue = new Ligue("La LDC");
		((Collection<Ligue>) ligue).add((Ligue) ligues);

	}
	
	
}
