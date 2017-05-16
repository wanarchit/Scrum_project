package Noyau_fonctionnel;

import scrum.noyau.Specie;
import org.junit.After;
import org.junit.Before;

public class TestSpecie {
	
	private Specie specie;
	
	@Before
    public void setUp()
    {
		specie = new Specie("nom");
    }
		
    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown()
    {
    }

}
