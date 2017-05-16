package scrum.noyau;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOrder {
	
	private Order order;

	@Before
    public void setUp()
    {
		order = new Order(new Customer("nom", "ville"));
    }
		
    /**
     * S'execute apres les test (pas utile ici)
     */
    @After
    public void tearDown()
    {
    }
	
    /**
     * Permet de tester l'ajout d'un order
     */
	@Test
	public void testAddOrder()
	{ 
		
	}

	/**
	 * Permet de tester un ajout duliqué d'un order pour un customer
	 */
    @Test
	public void testAddOrderBad()
	{
    	
	}

}
