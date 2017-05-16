package Noyau_fonctionnel;

import java.util.List;
import scrum.noyau.Specie;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import scrum.noyau.OrderStatus;
import scrum.noyau.Sample;

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
    
    /**
     * Permet de tester la récupération du nom
     */
    @Test
    public void testGetNameSpecie() {
        assertEquals("nom", specie.getName());
    }
    

}
