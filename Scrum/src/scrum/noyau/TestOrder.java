package scrum.noyau;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
	public void testInitialisationStatus()
	{ 
		assertEquals(OrderStatus.inProgress,order.getStatus());
	}

	/**
	 * Permet de tester la modification des samples et la modification du status
	 */
    @Test
	public void testSetSamples()
	{
    	List<Sample> samps = null;
    	order.setSamples(samps);
    	assertEquals(OrderStatus.toAnalyze,order.getStatus());
	}
}
